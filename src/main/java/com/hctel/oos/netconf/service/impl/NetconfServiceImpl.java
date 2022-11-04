package com.hctel.oos.netconf.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.common.utils.PrettyJSON;
import com.hctel.oos.ncmount.alarm.entity.AlarmMaskState;
import com.hctel.oos.ncmount.entity.*;
import com.hctel.oos.ncmount.performance.entity.Performance;
import com.hctel.oos.ncmount.pg.entity.PG;
import com.hctel.oos.ncmount.pg.entity.PGSwitch;
import com.hctel.oos.ncmount.topology.entity.NodeInfo;
import com.hctel.oos.netconf.service.NetconfService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.hctel.oos.netconf.utils.ODLNetconfChannelUtils.*;

@Service("netconfService")
public class NetconfServiceImpl implements NetconfService {
    /*
        说明：
            现在将所有的返回报文都设置为String类型
            以后会修改为Java实体类更加方便
            if (true) 为打印信息和部分预留代码
     */

    @Resource
    private ODLNetconfChannelUtils ODLNetconfChannelUtils;


    //////////////////////////////////测试用例//////////////////////////////////////////
    @Override
    public String testRpcs(String strJson) {
        return ODLNetconfChannelUtils.postRequest("hclink", "acc-eth:create-eth-connection", strJson);
    }

    @Override
    public String testRpcs1(String strJson) {
//        Integer integer = netconfUtils.postRequest(strJson);
//        System.out.println("返回状态"+integer);
//        return integer.toString();

        return ODLNetconfChannelUtils.putRequest(strJson).toString();
    }
    /////////////////////////////////////////////////////////////////////////////////


    @Override
    public String configNotification(String nodeName, Object setContext) {
        String module = "notifications:create-subscription";
        return ODLNetconfChannelUtils.postRequest(nodeName, module, setContext);
    }


    //////////////////////////////////节点模块////////////////////////////////////////

    /**
     * 此函数只是显示对应网元的状态信息，关键在于state字段
     */
    @Override
    public String getNodeList() {
        String result = null;
        NodeInfo nodeInfo1 = new NodeInfo();
        System.out.println("---" + nodeInfo1);
//        if (false) {
//            List<NodeInfo> nodeInfos = nodeInfoDao.getAll();
//            List<CInfos> cInfos = new ArrayList<>();
//
//            //构造赋值
//            /*
//                List<Integer> list  = new ArrayList<>();
//                List<Integer> list2 = new ArrayList<>(list);
//            */
//            for (NodeInfo nodeInfo : nodeInfos) {
//                //注意实体的声明需要在内部，在循环外部声明add方法只会添加最后一次的
//                CInfos cInfo = new CInfos();
//                BeanUtils.copyProperties(nodeInfo, cInfo);
//                cInfo.setStatus("connecting");
//                System.out.println("复制后的数据：" + JSON.toJSONString(cInfo));
//                cInfos.add(cInfo);
//            }
//            //JSON.toJSONString(cInfos, SerializerFeature.DisableCircularReferenceDetect)
//            //将实体转成JSON字符串
//            System.out.println("数据库中的数据为： " + JSON.toJSONString(cInfos, SerializerFeature.DisableCircularReferenceDetect));
//
//            String s = JSON.toJSONString(cInfos, SerializerFeature.DisableCircularReferenceDetect);
//            //格式化JSON数据
//            String pretty = PrettyJSON.pretty(s);
//            System.out.println("转化后的json数据： \n" + pretty + "\n");
//            return JSON.toJSONString(cInfos, SerializerFeature.DisableCircularReferenceDetect);
//        }
        JSONObject obj = ODLNetconfChannelUtils.getRequest(operational);
        System.out.println("【info:】" + obj);
        JSONArray netconfTopology = obj.getJSONArray("topology");
        JSONObject topology = netconfTopology.getJSONObject(0);
        if (topology.containsKey("node")) {
            System.out.println("该拓扑下有节点，信息如下：");
            JSONArray nodes = topology.getJSONArray("node");
            result = nodes.toJSONString();
            if (true) {
                System.out.println(nodes);
                for (Object n : nodes) {
                    JSONObject nodeInfo = (JSONObject) JSON.toJSON(n);

                    String strNodeId = nodeInfo.getString("node-id");
                    String strConnectStatus = nodeInfo.getString("netconf-node-topology:connection-status");
                    String strPort = nodeInfo.getString("netconf-node-topology:port");
                    String strHostIp = nodeInfo.getString("netconf-node-topology:host");

                    System.out.println("【节点名称】:" + strNodeId);
                    System.out.println("【连接状态】:" + strConnectStatus);
                    System.out.println("【连接端口】:" + strPort);
                    System.out.println("【连接IP】:" + strHostIp);
                }
            }

        }
        return result;
    }

    @Override
    public String getNode(String nodeName) {
        return ODLNetconfChannelUtils.getRequest(operational, nodeName).toJSONString();
    }

    /**
     * 创建节点信息
     *
     * @param node 节点名称
     * @return http响应状态码
     */
    @Override
    public Integer createNode(NodeInfo node) {
        if (node.getName().isEmpty())
            return 0;
        /*
         * 节点在创建的时候，可以一次创建多个节点，node是数组
         * 在此处将node作为一个节点，一条json而非json Array
         * 设备下发json报文可以接收多个节点创建修改
         *
         * */
//        int insert = nodeInfoDao.insert(node);
//        System.out.println("成功插入数据： " + insert);
        JSONObject jsonObject = new JSONObject();
        System.out.println("设备类型： " + node.getType());
        /*
         * fastjson的使用：
         * 一、Java实体转JSONObject
         *   若Java实体类为 User user = new User();
         *   使用 String jsonStr = JSON.toJSONString(user); 转换为json字符串
         *   再使用 JSONObject jsonObject = JSONObject.parseObject(jsonStr);
         *   最后jsonObject为json报文格式
         * 二、Java实体转JSON
         *   User user = new User();
         *   方法一： JSONObject jsonObj = (JSONObject) JSON.toJSON(user);
         *   方法二： JSON json = (JSON) JSON.toJSON(user);
         *   注： 在实体中没有数据的字段，在转化为json时会自动忽略
         * 三、JSON转Java实体
         *   方法一 （JSON转Java实体对象）：
         *       User user =JSON.parseObject(json,User.class); //反序列化
         *   方法二 （JSONObject转Java实体）：
         *       User user=JSON.toJavaObject(jsonObject, User.class);
         *   注： 在实体中没有数据的字段，在转化为json时会自动忽略
         * */

        //SerializerFeature.DisableCircularReferenceDetect
        //消除循环引用
        //String s = JSON.toJSONString(node, SerializerFeature.DisableCircularReferenceDetect);
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(node));
        jsonObject1.remove("id");
        jsonObject1.remove("type");
        jsonObject.put("node", jsonObject1);
        System.out.println("最后的JSON字符串：" + jsonObject);

        return ODLNetconfChannelUtils.putRequest(node.getName(), jsonObject);
    }

    @Override
    public NodeInfo getConfigNode(String nodeName) {
        JSONObject request = ODLNetconfChannelUtils.getRequest(config, nodeName);
        JSONObject node = request.getJSONArray("node").getJSONObject(0);
        return JSON.toJavaObject(node, NodeInfo.class);
    }

    @Override
    public Integer deleteNode(String nodeName) {
        return ODLNetconfChannelUtils.deleteRequest(nodeName);
    }

    /**
     * 指定节点信息下的统计详情
     *
     * @param nodeName 节点名称
     * @return 统计详情json字符串
     */
    @Override
    public String getNodeStatistics(String nodeName) {
        JSONObject obj = ODLNetconfChannelUtils.getRequest(operational, nodeName, NETCONF_STATISTICS);
        JSONObject statistics = obj.getJSONObject("statistics");
        System.out.println("【Infos1】：" + statistics);
        if (true) {
            String string = statistics.getString("out-rpc-errors");
            Integer integer = statistics.getInteger("in-bad-hellos");
            String string1 = statistics.getString("out-notifications");
            String string2 = statistics.getString("in-rpcs");
            String string3 = statistics.getString("dropped-sessions");
            String string4 = statistics.getString("in-sessions");
            String string5 = statistics.getString("netconf-start-time");

            String string6 = statistics.getString("in-bad-rpcs");
            System.out.println("------------------统计信息汇总-------------------");
            System.out.println("rpc错误总数：" + string);
            System.out.println("打招呼错误总数：" + integer);
            System.out.println("通知输出总数：" + string1);
            System.out.println("所有rpc总数：" + string2);
            System.out.println("删除会话总数：" + string3);
            System.out.println("内置会话总数：" + string4);
            System.out.println("南向开始时间：" + string5);
            System.out.println("rpc错误总数：" + string6);
            System.out.println("------------------------------------------------");
        }

        return statistics.toJSONString();

    }

    /**
     * 指定节点的会话详情
     *
     * @param nodeName 节点名称
     * @return 该返回值为列表字段，现在设置为String
     */
    @Override
    public String getNodeSession(String nodeName) {
        System.out.println("节点名称：" + nodeName);
        JSONObject obj = ODLNetconfChannelUtils.getRequest(operational, nodeName, "ietf-netconf-monitoring:netconf-state/sessions");
        JSONObject sessions = obj.getJSONObject("sessions");
        JSONArray session = sessions.getJSONArray("session");
        if (true) {
            for (int i = 0; i < session.size(); i++) {
                JSONObject jsonObject = session.getJSONObject(i);
                String id = jsonObject.getString("session-id");
                String hostIp = jsonObject.getString("source-host");
                String loginTime = jsonObject.getString("login-time");
                String username = jsonObject.getString("username");
                String sumRpcErrors = jsonObject.getString("out-rpc-errors");
                String sumOutNotifications = jsonObject.getString("out-notifications");
                String transport = jsonObject.getString("transport");
                String sumRpcs = jsonObject.getString("in-rpcs");
                String sumBadRpcs = jsonObject.getString("in-bad-rpcs");
                System.out.println("==========================信息统计=============================");
                System.out.println("会话id：" + id);
                System.out.println("登录主机IP：" + hostIp);
                System.out.println("登录时间：" + loginTime);
                System.out.println("登录用户：" + username);
                System.out.println("错误rpc总数：" + sumRpcErrors);
                System.out.println("通知上报总数：" + sumOutNotifications);
                System.out.println("传输方式：" + transport);
                System.out.println("Rpc总数：" + sumRpcs);
                System.out.println("正存在问题rpc数量：" + sumBadRpcs);
                System.out.println("==============================================================");
            }
        }
        return sessions.toJSONString();
    }

    @Override
    public String getSchemas(String nodeName) {
        JSONObject obj = ODLNetconfChannelUtils.getRequest(operational, nodeName, "ietf-netconf-monitoring:netconf-state/schemas");
        JSONObject schemas = obj.getJSONObject("schemas");
        JSONArray schema = schemas.getJSONArray("schema");
        System.out.println("【Infos】：" + schema);
        return schema.toJSONString();

    }
    /////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////网元设备模块//////////////////////////////////////

    @Override
    public String getNodeMe(String nodeName) {
        JSONObject obj = ODLNetconfChannelUtils.getRequest(operational, nodeName, ME);
        JSONObject me = obj.getJSONObject("me");

        if (true) {
            System.out.println(PrettyJSON.pretty(me.toJSONString()));
            System.out.println("————————————————————设备信息表————————————————————————");
            String name = me.getString("name");
            System.out.println("设备名称：" + name);
            String ip = me.getString("ip-address");
            System.out.println("ip-地址：" + ip);
            String status = me.getString("status");
            System.out.println("运行状态：" + status);
            String mask = me.getString("mask");
            System.out.println("子网掩码：" + mask);
            String string = me.getString("gate-way1");
            System.out.println("网关1：" + string);
            String string1 = me.getString("gate-way2");
            System.out.println("网关2：" + string1);
            String string2 = me.getString("ntp-enable");
            System.out.println("ntp状态：" + string2);
            System.out.println("————————————————————————————————————————————————————");

        }
        return me.toJSONString();
    }

    @Override
    public String getNodeEqs(String nodeName) {
        String module = "acc-devm:eqs";
//        System.out.println(PrettyJSON.pretty(ODLNetconfChannelUtils.getRequest(config, nodeName, module).toJSONString()));
        JSONObject eqs = new JSONObject();
        eqs.put("eqs","");
        String response = ODLNetconfChannelUtils.generalGetRequest(nodeName, eqs);
        System.out.println(PrettyJSON.pretty(response));
        JSONObject jsonObject = JSONObject.parseObject(response);
        JSONObject data = jsonObject.getJSONObject("output").getJSONObject("data");
        return data.toJSONString();
    }

    @Override
    public String getNtpServers(String nodeName) {
        JSONObject obj = ODLNetconfChannelUtils.getRequest(config, nodeName, "acc-devm:me/ntp-servers");
        JSONObject ntps = obj.getJSONObject("ntp-servers");
        System.out.println("【Infos】：" + ntps);

        return ntps.toJSONString();

    }

    @Override
    public String configOduPtpPac(String nodeName, String ptpName, OduPtpPac oduPtpPac) {

        JSONObject obj = new JSONObject();


        return ODLNetconfChannelUtils.generalEditConfigRequest(nodeName,obj);
//        String module = "acc-devm:ptps/ptp/" + ptpName + "/acc-otn:odu-ptp-pac";
//        String rCode = ODLNetconfChannelUtils.postRequest(nodeName, module, oduPtpPac);
//        return rCode;
    }

    @Override
    public String setSdhTerminationPointData(String nodeName, String ptpName, SdhPtpPac sdhPtpPac) {
        String module = "acc-devm:ptps/ptp/" + ptpName + "/acc-sdh:sdh-ptp-pac";
        Integer integer = ODLNetconfChannelUtils.putRequest(nodeName, module, sdhPtpPac);
        return String.valueOf(integer);
    }

    @Override
    public String configEthPtpPac(String nodeName, String ptpName, EthPtpPac ethPtpPac) {
        String module = "acc-devm:ptps/ptp/" + ptpName + "/acc-eth:eth-ptp-pac";
        Integer integer = ODLNetconfChannelUtils.putRequest(nodeName, module, ethPtpPac);
        return String.valueOf(integer);
    }

    @Override
    public String configEthOamPac(String nodeName, String ctpName, EthOamPac ethOamPac) {
        String module = "acc-devm:ctps/ctp/" + ctpName + "/acc-eth:eth-ctp-pac/oam-config";
        JSONObject object = (JSONObject) JSON.toJSON(ethOamPac);
        JSONObject t_EthOamPac = new JSONObject();
        t_EthOamPac.put("oam-config", object);
        return ODLNetconfChannelUtils.putRequest(nodeName, module, t_EthOamPac).toString();
    }

    @Override
    public String configEthOamStatePac(String nodeName, String ctpName, EthOamStatePac ethOamStatePac) {
        String module = "acc-devm:ctps/ctp/" + ctpName + "/acc-eth:eth-ctp-pac/oam-state-pac";
        JSONObject object = (JSONObject) JSON.toJSON(ethOamStatePac);
        JSONObject t_EthOamStatePac = new JSONObject();
        t_EthOamStatePac.put("oam-config", object);
        return ODLNetconfChannelUtils.putRequest(nodeName, module, t_EthOamStatePac).toString();
    }

    @Override
    public String configNtpServers(String nodeName, JSONObject jsonObject) {
        String module = "acc-devm:me/ntp-servers";

        Integer integer = ODLNetconfChannelUtils.putRequest(nodeName, module, jsonObject);
        return String.valueOf(integer);
    }

    @Override
    public String setManagedElementTime(String nodeName, String newTime) {
        String module = "acc-devm:set-managed-element-time";
        JSONObject str = new JSONObject();
        str.put("new-time", newTime);
        JSONObject t_time = new JSONObject();
        t_time.put("input", str);
        JSONObject t_meTime = new JSONObject();
        t_meTime.put("set-managed-element-time", t_time);

        return ODLNetconfChannelUtils.postRequest(nodeName, module, t_meTime).toString();
    }

    @Override
    public String getManagedElementTime(String nodeName) {
        String module = "acc-devm:get-managed-element-time";
        String str = ODLNetconfChannelUtils.postRequest(nodeName, module);
        System.out.println("rpc : \n-get me time " + str);
        JSONObject object = JSONObject.parseObject(str);

        JSONObject output = object.getJSONObject("output");

        return output.toJSONString();
    }

    /**
     * 指定节点信息下的统计详情
     *
     * @param nodeName 节点名称
     * @return 统计详情json字符串
     */
    @Override
    public String getPtps(String nodeName) {
        String module = "acc-devm:ptps";
        JSONObject obj = ODLNetconfChannelUtils.getRequest(config, nodeName, module);
        JSONObject ptps = obj.getJSONObject("ptps");
        JSONArray ptpArr = ptps.getJSONArray("ptp");

        return ptpArr.toJSONString();

    }

    @Override
    public String getPtp(String nodeName, String ptpName) {
        String module = "acc-devm:ptps/ptp/" + ptpName;
        return ODLNetconfChannelUtils.getRequest(config, nodeName, module).toJSONString();
    }

    @Override
    public String getFtps(String nodeName) {
        JSONObject obj = ODLNetconfChannelUtils.getRequest(operational, nodeName, "acc-devm:ftps");
        JSONObject ftps = obj.getJSONObject("ftps");
        JSONArray ftpArr = ftps.getJSONArray("ftp");
        System.out.println(ftpArr);
        return ftpArr.toJSONString();
    }

    @Override
    public String getFtp(String nodeName, String ftpName) {
        String module = "acc-devm:ftps/ftp/" + ftpName;
        return ODLNetconfChannelUtils.getRequest(config, nodeName, module).toJSONString();
    }

    @Override
    public String getCtps(String nodeName) {
        JSONObject obj = ODLNetconfChannelUtils.getRequest(config, nodeName, "acc-devm:ctps");
        if (obj == null) {
            obj = ODLNetconfChannelUtils.getRequest(operational, nodeName, "acc-devm:ctps");
        }
        JSONObject ctps = obj.getJSONObject("ctps");
        System.out.println(ctps);
        JSONArray ctpArr = ctps.getJSONArray("ctp");
        return ctpArr.toJSONString();
    }

    @Override
    public String getCtp(String nodeName, String ctpName) {
        String module = "acc-devm:ctps/ctp/" + ctpName;
        return ODLNetconfChannelUtils.getRequest(config, nodeName, module).toJSONString();
    }

    @Override
    public String configVcgPac(String nodeName, String ftpName, VcgPac vcgPac) {
        String module = "acc-devm:ftps/ftp/" + ftpName + "/acc-eth:eth-ftp-pac/acc-eos:vcg-pac";
        return ODLNetconfChannelUtils.putRequest(nodeName, module, vcgPac).toString();
    }

    ///////////////////////////////告警模块////////////////////////////////////////
    @Override
    public String alarmNotification(String nodeName) {
        String module = "acc-alarms:alarms";
        return null;
    }

    @Override
    public String getAlarmTcas(String nodeName) {
        JSONObject alarmTcas = new JSONObject();
        alarmTcas.put("alarms", getAlarms(nodeName));
        alarmTcas.put("tcas", getTcas(nodeName));
        return alarmTcas.toJSONString();
    }

    public JSONObject getAlarms(String nodeName) {
        String module = "acc-alarms:alarms";
        return ODLNetconfChannelUtils.getRequest(operational, nodeName, module);
    }

    public JSONObject getTcas(String nodeName) {
        String module = "acc-alarms:tcas";
        return ODLNetconfChannelUtils.getRequest(operational, nodeName, module);
    }

    @Override
    public String getHistoryAlarms(String nodeName, String inputTime) {
        String module = "acc-alarms:get-history-alarms";
        JSONObject input = new JSONObject();
        input.put("input", inputTime);
        JSONObject t_getHistoryAlarms = new JSONObject();
        t_getHistoryAlarms.put("get-history-alarms", input);
        return ODLNetconfChannelUtils.postRequest(nodeName, module, t_getHistoryAlarms);
    }

    @Override
    public String configAlarmMaskState(String nodeName, AlarmMaskState alarmMaskState) {
        JSONObject object = (JSONObject) JSON.toJSON(alarmMaskState);
        JSONArray maskArr = new JSONArray();
        maskArr.add(object);
        JSONObject maskObj = new JSONObject();
        maskObj.put("alarm-mask-state", maskArr);
        JSONObject maskObjs = new JSONObject();
        maskObjs.put("alarm-mask-states", maskObj);
        String module = "acc-alarms:alarm-mask-states";
        return ODLNetconfChannelUtils.putRequest(nodeName, module, maskObjs).toString();
    }

    @Override
    public String getAlarmMaskState(String nodeName, AlarmMaskState alarmMaskState) {
        String module = "";
        if (alarmMaskState.getAlarmCode()==null||alarmMaskState.getObjectName()==null){
            module = "acc-alarms:alarm-mask-states";
        }else {
            module = "acc-alarms:alarm-mask-states" + alarmMaskState.getObjectName() + alarmMaskState.getAlarmCode();
        }
        return ODLNetconfChannelUtils.getRequest(operational, nodeName, module).toJSONString();
    }
    //////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////性能模块///////////////////////////////////////
    @Override
    public String TCANotification(String nodeName) {
        return null;
    }

    @Override
    public String configTcaParameter(String nodeName, List<TcaParameter> tcaParameter) {
        String module = "acc-alarms:tca-parameters";
        JSONArray tcaArr = new JSONArray();
        for (TcaParameter parameter : tcaParameter) {
            JSONObject object = (JSONObject) JSON.toJSON(parameter);
            tcaArr.add(parameter);
        }
        JSONObject tca = new JSONObject();
        tca.put("tca-parameter", tcaArr);
        JSONObject tcas = new JSONObject();
        tcas.put("tca-parameters", tca);

        return ODLNetconfChannelUtils.putRequest(nodeName, module, tcas).toString();
    }

    @Override
    public String getTcaParameter(String nodeName, TcaParameter tcaParameter) {
        String module = "acc-alarms:tca-parameters/tca-parameter" + tcaParameter.getObjectName()
                + tcaParameter.getPmParameterName() + tcaParameter.getGranularity()
                + tcaParameter.getThresholdType();
        return ODLNetconfChannelUtils.getRequest(operational, nodeName, module).toJSONString();
    }

    @Override
    public String getPerformances(String nodeName, Performance performance) {
        String module = "acc-performance:performances";
        if (!performance.getPmParameterName().isEmpty()) {
            module = module + performance.getObjectName() + performance.getPmParameterName() + performance.getStartTime();
        }
        return ODLNetconfChannelUtils.getRequest(operational, nodeName, module).toJSONString();
    }

    @Override
    public String getHistoryPerformanceMonitoringData(String nodeName, String inputJson) {
        String module = "acc-performance:get-history-performance-monitoring-data";
        JSONObject input = new JSONObject();
        input.put("input", inputJson);
        JSONObject getHPMD = new JSONObject();
        getHPMD.put("get-history-performance-monitoring-data", input);
        return ODLNetconfChannelUtils.postRequest(nodeName, module, getHPMD);
    }

    //////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////故障诊断////////////////////////////////////////

    @Override
    public String configTpLookBack(String nodeName, String tpName, String loopbackType) {
        return null;
    }

    @Override
    public String getTpLookBackState(String nodeName, String tpName) {
        return null;
    }

    @Override
    public String configEqsReset(String nodeName, Eq eq) {
        String module = "acc-devm:reset";
        JSONObject input = new JSONObject();
        input.put("input", eq);
        JSONObject reset = new JSONObject();
        reset.put("reset", input);
        System.out.println("包装好的数据： " + reset);
        return ODLNetconfChannelUtils.postRequest(nodeName, module, reset);
    }

    @Override
    public String configPtpLaser(String nodeName, String ptpName, String laserStatus) {

        String ptp = getPtp(nodeName, ptpName);
        JSONObject object1 = JSONObject.parseObject(ptp);
        JSONArray ptpArr = object1.getJSONArray("ptp");
        JSONObject object2 = ptpArr.getJSONObject(0);

        object2.put("laser-status", laserStatus);
        JSONArray ptpArr1 = new JSONArray();
        ptpArr1.add(object2);
        JSONObject obj = new JSONObject();
        obj.put("ptp", ptpArr1);

        String module = "acc-devm:ptps/ptp/" + ptpName;
        return ODLNetconfChannelUtils.putRequest(nodeName, module, obj).toString();
    }

    @Override
    public String getPtpLaser(String nodeName, String ptpName) {
        String ptp = getPtp(nodeName, ptpName);
        JSONObject object1 = JSONObject.parseObject(ptp);
        JSONArray ptpArr = object1.getJSONArray("ptp");
        JSONObject object2 = ptpArr.getJSONObject(0);
        return object2.getJSONObject("laser-status").toJSONString();
    }
    /////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////保护组管理///////////////////////////////////////
    @Override
    public String getPgs(String nodeName) {
        JSONObject obj = ODLNetconfChannelUtils.getRequest(config, nodeName, "acc-protection-group:pgs");
        JSONObject pgs = obj.getJSONObject("pgs");
        return pgs.toJSONString();
    }

    @Override
    public String getPg(String nodeName, String pgId) {
        String module = "acc-protection-group:pgs/pg/" + pgId;
        return ODLNetconfChannelUtils.getRequest(config, nodeName, module).toString();
    }

    @Override
    public String createPgs(String nodeName, PG pg) {
        String module = "acc-protection-group:pgs";
        JSONObject pgs = new JSONObject();
        JSONArray t_pg = new JSONArray();
        t_pg.add(pg);
        pgs.put("pg", t_pg);
        System.out.println(PrettyJSON.pretty(pgs.toJSONString()));
        return ODLNetconfChannelUtils.putRequest(nodeName, module, pgs).toString();
    }

    @Override
    public String deletePg(String nodeName, String pgId) {
        String module = "acc-protection-group:pgs/pg/" + pgId;
        return ODLNetconfChannelUtils.deleteRequest(nodeName, module).toString();
    }

    @Override
    public String performProtectionCommand(String nodeName, PGSwitch pgSwitch) {
        String module = "acc-protection-group:perform-protection-command";
        JSONObject obj = new JSONObject();
        obj.put("input", pgSwitch);
        JSONObject t_pgSwitch = new JSONObject();
        t_pgSwitch.put("perform-protection-command", obj);
        ODLNetconfChannelUtils.postRequest(nodeName, module, t_pgSwitch);
        return null;
    }

    @Override
    public String switchSdTriggerEnable(String nodeName, String pgId, boolean SdTrigger) {
        // 先get该保护组的信息
        String pg = getPg(nodeName, pgId);
        JSONObject object = JSONObject.parseObject(pg);
        //再将其中的 SD 触发保护倒换设置 改成我们设置的数据
        object.put("sd-trigger", SdTrigger);
        System.out.println(PrettyJSON.pretty(object.toJSONString()));
        String module = "acc-protection-group:pgs/pg/" + pgId;
        //下发报文
        return ODLNetconfChannelUtils.putRequest(nodeName, module, object).toString();
    }

    @Override
    public String getSwitchSdTriggerStatus(String nodeName, String pgId) {
        String module = "acc-protection-group:pgs/pg/" + pgId;
        JSONObject request = ODLNetconfChannelUtils.getRequest(config, nodeName, module);
        JSONArray pg = request.getJSONArray("pg");
        JSONArray t_pg = new JSONArray();
        JSONObject sub = new JSONObject();
        for (int i = 0; i < pg.size(); i++) {
            JSONObject jsonObject = pg.getJSONObject(i);
            sub.put("pg-id", jsonObject.getJSONObject("pg-id"));
            sub.put("sd-trigger", jsonObject.getJSONObject("sd-trigger"));
            t_pg.add(sub);
        }
        return t_pg.toJSONString();
    }

    /////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////业务发放管理接口//////////////////////////////////////
    @Override
    public String createEthConnection(String nodeName, String jsonMessage) {
        String module = "acc-eth:create-eth-connection";
        String s = ODLNetconfChannelUtils.postRequest(nodeName, module, jsonMessage);
        return s;
    }

    @Override
    public String createEthToEthConnection(String nodeName, String jsonStr) {
        String module = "acc-eth:create-eth-to-eth-connection";
        return ODLNetconfChannelUtils.postRequest(nodeName, module, jsonStr);
    }

    @Override
    public String createSdhConnection(String nodeName, String jsonStr) {
        String module = "acc-sdh:create-sdh-connection";
        return ODLNetconfChannelUtils.postRequest(nodeName, module, jsonStr);
    }

    @Override
    public String createOduConnection(String nodeName, String jsonStr) {
        String module = "acc-otn:create-odu-connection";
        return ODLNetconfChannelUtils.postRequest(nodeName, module, jsonStr);
    }

    @Override
    public String createEosConnection(String nodeName, String jsonStr) {
        String module = "acc-eos:create-eos-connection";
        return ODLNetconfChannelUtils.postRequest(nodeName, module, jsonStr);
    }

    @Override
    public String deleteConnection(String nodeName, String connName) {
        String module = "acc-connection:connections/connection/"+connName;
        return ODLNetconfChannelUtils.deleteRequest(nodeName, module).toString();
    }

    @Override
    public String getConnections(String nodeName) {
        String module = "acc-connection:connections";
        JSONObject request = ODLNetconfChannelUtils.getRequest(config, nodeName, module);
        if (request.isEmpty()) {
            return null;
        }
        JSONObject connections = request.getJSONObject("connections");
        return connections.toJSONString();
    }

    @Override
    public String getConnection(String nodeName, String connName) {
        String module = "acc-connection:connections/connection/"+connName;
        JSONObject request = ODLNetconfChannelUtils.getRequest(config, nodeName, module);
        if (request.isEmpty()) {
            return null;
        }
        return request.toJSONString();
    }

    @Override
    public String modifyEthConnectionCapacity(String nodeName, String jsonStr) {
        String module = "acc-eth:modify-eth-connection-capacity";
        return ODLNetconfChannelUtils.postRequest(nodeName, module, jsonStr);
    }

    @Override
    public String modifyOduConnectionCapacity(String nodeName, String jsonStr) {
        String module = "acc-otn:modify-odu-connection-capacity";
        return ODLNetconfChannelUtils.postRequest(nodeName, module, jsonStr);
    }

    @Override
    public String modifyVcgConnectionCapacity(String nodeName, String jsonStr) {
        String module = "acc-eos:modify-vcg-connection-capacity";
        return ODLNetconfChannelUtils.postRequest(nodeName,module,jsonStr);
    }


    /////////////////////////////////////////////////////////////////////////////////


}
