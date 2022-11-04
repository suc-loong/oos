package com.hctel.oos.ncmount.topology.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.common.utils.PrettyJSON;
import com.hctel.oos.ncmount.topology.entity.NodeInfo;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.hctel.oos.netconf.utils.ODLNetconfChannelUtils.*;

/**
 * Description
 * 拓扑层级的操作实现（获取拓扑下的网元，对拓扑下的网元进行增、删、改、查）
 *
 * @Author wcloong
 * @Date 2022/10/24 9:52
 * @Version 0.1.0
 */
@Service
public class TopologyMgrServicesImpl implements TopologyMgrServices {
    @Resource
    private ODLNetconfChannelUtils ODLNetconfChannelUtils;

    /**
     * 此函数只是显示对应网元的状态信息，关键在于state字段
     */
    @Override
    public String getNodeList() {
        String result = null;
        JSONObject obj = ODLNetconfChannelUtils.getRequest(operational);
        System.out.println("【网元列表:】" + obj);
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

            System.out.println("xxxxx\n"+ PrettyJSON.pretty(result));
            System.out.println("-----------------------------------------------");
//            return topology.toJSONString();

        }

        return result;
    }

    @Override
    public String getAllNode() {
        JSONObject allRequest = ODLNetconfChannelUtils.getAllRequest();
        if (allRequest.containsKey("network-topology:topology")){
            JSONArray netconfTopology = allRequest.getJSONArray("network-topology:topology");
            JSONObject topology = netconfTopology.getJSONObject(0);
            if (topology.containsKey("node")) {
                System.out.println("该拓扑下有节点，信息如下：");
                JSONArray nodes = topology.getJSONArray("node");
                return nodes.toJSONString();
            }
        }
        return allRequest.toJSONString();
    }

    @Override
    public String getNode(String nodeName) {
        return ODLNetconfChannelUtils.getRequest(operational, nodeName).toJSONString();
    }

    @Override
    public Integer configNode(NodeInfo node) {
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


}
