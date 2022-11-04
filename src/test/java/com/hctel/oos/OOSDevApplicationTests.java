package com.hctel.oos;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.common.utils.LoadJSONFile;
import com.hctel.oos.common.utils.PrettyJSON;
import com.hctel.oos.login.entity.User;
import com.hctel.oos.netconf.service.NetconfService;
import com.hctel.oos.netconf.utils.NetconfProtocolUtils;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import net.juniper.netconf.NetconfException;
import net.juniper.netconf.XML;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class OOSDevApplicationTests {

    /**
     * 服务对象
     */
    @Resource
    NetconfService netconfService;

    @Resource
    ODLNetconfChannelUtils ODLNetconfChannelUtils;

    @Resource
    NetconfProtocolUtils netconfProtocolUtils;

    @Test
    void contextLoads() {

//        String s = "fooStyleCss";
//        s = s.replace(/([A-Z])/g,"-$1").toLowerCase();




    }

    @Test
    public void getJson() {
        String node = "hclink1";
        LoadJSONFile loadJSONFile = new LoadJSONFile();
        JSONObject obj = loadJSONFile.getLoadJson(node);
        JSONArray node1 = obj.getJSONArray("node");
        JSONObject jsonObject = node1.getJSONObject(1);

        System.out.println("===========================");
        System.out.println(jsonObject);

        jsonObject.put("node-id","test1");
        System.out.println("===========================");

        System.out.println(jsonObject);

    }

    @Test
    public void tUrl() {
        String url = ODLNetconfChannelUtils.getUrl("operations", null);
        String link = ODLNetconfChannelUtils.getUrl(ODLNetconfChannelUtils.config, "hclink");
        System.out.println(url);
    }

    @Test
    public void createNode() {
        String node = "otna";

        LoadJSONFile loadJSONFile = new LoadJSONFile();
        JSONObject obj = loadJSONFile.getLoadJson(node);
        Integer integer = ODLNetconfChannelUtils.putRequest(node, obj);
        System.out.println("返回操作状态： " + integer);
    }

    @Test
    public void createNode1() {
        String node = "hclink";

        LoadJSONFile loadJSONFile = new LoadJSONFile();
        JSONObject obj = loadJSONFile.getLoadJson(node);
        Integer integer = ODLNetconfChannelUtils.putRequest(node, obj);
        System.out.println("返回操作状态： " + integer);
    }

    @Test
    public void createNode2() {
        String node = "otndev";

        LoadJSONFile loadJSONFile = new LoadJSONFile();
        JSONObject obj = loadJSONFile.getLoadJson(node);
        Integer integer = ODLNetconfChannelUtils.putRequest(node, obj);
        System.out.println("返回操作状态： " + integer);
    }


    @Test
    public void getNode(){
        JSONObject otna = ODLNetconfChannelUtils.getRequest(ODLNetconfChannelUtils.operational, "otna");
        JSONArray node = otna.getJSONArray("node");
        JSONObject jsonObject = node.getJSONObject(0);
        String string = jsonObject.getString("node-id");
        System.out.println(string);
        String string1 = jsonObject.getString("netconf-node-topology:connection-status");
        System.out.println(string1);

    }

    @Test
    public void getAlarm(){
        System.out.println(netconfService.getAlarmTcas("otna"));
    }
    @Test
    public void getCtp(){
        System.out.println(netconfService.getCtps("otna"));

    }

    @Test
    public void deleteNode(){
        String name = "otna";
        System.out.println(netconfService.deleteNode(name));

    }



    @Test
    public void testNetconfMe()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<me xmlns=\"urn:ccsa:yang:acc-devm\">\n" +

                    "</me>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }


    @Test
    public void testNetconfEqs()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<eqs xmlns=\"urn:ccsa:yang:acc-devm\">\n" +

                    "</eqs>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }



    @Test
    public void testNetconfPtps()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<ptps xmlns=\"urn:ccsa:yang:acc-devm\">\n" +

                    "</ptps>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }

    @Test
    public void testNetconfFtps()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<ftps xmlns=\"urn:ccsa:yang:acc-devm\">\n" +

                    "</ftps>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }

    @Test
    public void testNetconfCtps()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<ctps xmlns=\"urn:ccsa:yang:acc-devm\">\n" +

                    "</ctps>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }

    @Test
    public void testNetconfAlarms()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<alarms xmlns=\"urn:ccsa:yang:acc-alarms\">\n" +

                    "</alarms>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }

    @Test
    public void testNetconfAlarmsMask()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<alarm-mask-states xmlns=\"urn:ccsa:yang:acc-alarms\">\n" +
                    "</alarm-mask-states>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }

    @Test
    public void testNetconfTcas()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<tcas xmlns=\"urn:ccsa:yang:acc-alarms\">\n" +
                    "</tcas>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }

    @Test
    public void testNetconfTcaParameters()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<tca-parameters xmlns=\"urn:ccsa:yang:acc-alarms\">\n" +
                    "</tca-parameters>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }

    @Test
    public void testNetconfConnections()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<connections xmlns=\"urn:ccsa:yang:acc-connection\">\n" +

                    "</connections>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }


    @Test
    public void testNetconfPGs()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<pgs xmlns=\"urn:ccsa:yang:acc-protection-group\">\n" +

                    "</pgs>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }

    @Test
    public void testNetconfLags()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<lagPGs xmlns=\"urn:ccsa:yang:acc-protection-group\">\n" +

                    "</lagPGs>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }

    @Test
    public void testNetconfPerformances()  {
        XML send = null;
        try {
            send = netconfProtocolUtils.send("<get>\n" +
                    "<filter type=\"subtree\">\n" +

                    "<performances xmlns=\"urn:ccsa:yang:acc-performance\">\n" +

                    "</performances>\n" +

                    "</filter>\n" +
                    "</get>");
        } catch (NetconfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(send);
        System.out.println("-----------------------------------------------------------------------");

    }



    @Test
    public void getTcas(){
//        System.out.println(netconfService.getTcaParameter("otna"));
    }

    @Test
    public void getConnections(){
        System.out.println(netconfService.getConnections("otndev"));
    }



    /**
     * 节点下的统计信息汇总
     */
    @Test
    public void getStatistics() {
        netconfService.getNodeStatistics("otndev");

    }



    /**
     * 为了测试fastJson使用Java实体类和Json的转化
     */
    @Test
    public void testFastJson() {
        User user = new User();
//        user.setId(0L);
        user.setPassword("123456");
        user.setEmail("163@163.com");
        user.setPhone(18855888855L);

        JSONObject jsonObj = (JSONObject) JSON.toJSON(user);
        System.out.println("1.json: " + jsonObj);
        System.out.println("--------------------------------");
        JSON json = (JSON) JSON.toJSON(user);
        System.out.println("2.json: " + json);
        System.out.println("--------------------------------");
        JSONObject object = JSONObject.parseObject(JSON.toJSONString(user));
        System.out.println("3.json: " + object);


    }

    @Test
    public void testGet() {
        String url = "http://localhost:8181/restconf/config/network-topology:network-topology/topology/topology-netconf/node/hclink/yang-ext:mount/acc-connection:connections";

        String url1 = "http://localhost:8181/restconf/operational/network-topology:network-topology/topology/topology-netconf/node/hclink/yang-ext:mount/acc-devm:ctps";
        String url2 = "http://localhost:8181/restconf/operational/network-topology:network-topology/topology/topology-netconf/node/hclink/yang-ext:mount/acc-devm:ftps";
        String url3 = "http://localhost:8181/restconf/operational/network-topology:network-topology/topology/topology-netconf/node/hclink/yang-ext:mount/acc-devm:ptps";
//        JSONObject test1 = netconfUtils.getTest(url1);
//        JSONObject test2 = netconfUtils.getTest(url2);
        JSONObject test3 = ODLNetconfChannelUtils.getTest(url3);
       /* System.out.println("============================================ CTP");
        System.out.println("ctp:\n");
        System.out.println(PrettyJSON.pretty(test1.toJSONString()));
        System.out.println("============================================ CTP");
        System.out.println("============================================ FTP");
        System.out.println("ftp:\n");
        System.out.println(PrettyJSON.pretty(test2.toJSONString()));
        System.out.println("============================================ FTP");*/

        System.out.println("============================================ PTP");
        System.out.println("ptp:\n");
        System.out.println(PrettyJSON.pretty(test3.toJSONString()));
        System.out.println("============================================ PTP");
    }

    @Test
    public void testGet1() {
        String url = "http://127.0.0.1:8181/restconf/config/network-topology:network-topology/topology/topology-netconf/node/hclink/yang-ext:mount/acc-devm:ptps";
        JSONObject test3 = ODLNetconfChannelUtils.getTest(url);
        System.out.println("============================================ PTP");
        System.out.println("ptp:\n");
        System.out.println(PrettyJSON.pretty(test3.toJSONString()));
        System.out.println("============================================ PTP");
    }

    @Test
    public void testGet2() {
        String url = "http://127.0.0.1:8181/restconf/config/network-topology:network-topology/topology/topology-netconf/node/hclink";
        JSONObject test = ODLNetconfChannelUtils.getTest(url);
        JSONArray node = test.getJSONArray("node");
        JSONObject jsonObject = node.getJSONObject(0);
        System.out.println("============================================");
        System.out.println(PrettyJSON.pretty(jsonObject.toJSONString()));
        System.out.println("============================================");
    }


    @Test
    public void testPost() {
        netconfService.getNodeSession("otna");
    }

}
