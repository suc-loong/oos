package com.hctel.oos;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.common.utils.LoadJSONFile;
import com.hctel.oos.ncmount.topology.entity.CInfos;
import com.hctel.oos.ncmount.topology.entity.NodeInfo;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class TJson {


    @Test
    public void testNetconf(){
        // Create a device object and a default NETCONF session
//        Device device = null;
//        NetconfSession second_session;
//        try {
//            device = new Device("10.10.1.34", "admin", "PaSsWoRd", null);
//            device.connect();
//
//        } catch (NetconfException e) {
//            e.printStackTrace();
//        }
//
//
//        // There are two independent NETCONF sessions
//        assert device != null;
//        String default_session_id = device.getSessionId();
//        String second_session_id = second_session.getSessionID();
    }

    @Test
    public void test()  {
//        Device device = null;
//        try {
//            device = new Device("192.168.135.117", "admin", "830", null,"root","root","root");
//            device.connect();
//        } catch (NetconfException e) {
//            e.printStackTrace();
//        }
//
//        assert device != null;
//        NetconfSession second_session = device.createNetconfSession();

    }

    @Test
    public void tMessage(){
        CInfos cInfos = new CInfos();
        cInfos.setPort(23L);
        cInfos.setStatus("connecting");
        cInfos.setName("hctel");
        cInfos.setHost("1.2.3.4");


        org.json.JSONObject testObj = new org.json.JSONObject();
        try {
            testObj.put("cccn",cInfos);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(testObj);
/*
        try {
            System.out.println("-----------------------------------");
            // org.json:json中的 JSONML.toJSONObject 方法
            System.out.println(JSONML.toJSONObject(cInfos.toString()));
            System.out.println("-----------------------------------");
        } catch (JSONException e) {
            e.printStackTrace();
        }
*/

//        System.out.println(cInfos.toString());
//        System.out.println(JSON.toJSONString(cInfos));

    }


    @Test
    public void testPath(){
        String property = System.getProperty("user.dir");
        System.out.println("path: "+property);

    }

    @Test
    public void testReadJsonFile(){
        LoadJSONFile loadJSONFile = new LoadJSONFile();
        JSONObject otna = loadJSONFile.getLoadJson("otna");
        System.out.println("test: "+otna);
    }
    /**
     * 关于List的add方法探究为何循环内覆盖
     */
    @Test
    public void aboutListAdd(){

        //iia：源数据
        List<Integer> iia = new ArrayList<>();
        for (int i = 0;i<5;i++){
            iia.add(i,i);
        }
        System.out.println(iia);
        System.out.println("-----------------------");

        //iib：复制后的数据
        List<Integer> iib = new ArrayList<>();
        Integer iiTemp = new Integer(0);
        for (Integer integer : iia) {
            iiTemp = integer;
            iib.add(iiTemp);
        }
        System.out.println(iib);
        System.out.println("-----------------------");

        /**
         * Long型复制Integer型
         */
        List<Long> lla = new ArrayList<>();
        Long l_temp = new Long(0);
        for (Integer integer : iia) {
            l_temp = Long.valueOf(integer);
            lla.add(l_temp);
        }
        System.out.println("Long int :\n"+lla);
        System.out.println("-----------------------");

        //当为String类型时
        List<String> ssa = new ArrayList<>();
        for (int i=0;i<6;i++){
            ssa.add(i,"h"+i);
        }
        System.out.println("string 的 List 值\n"+ssa);

        List<String> ssb = new ArrayList<>();
        String str = new String();
        for (String s : ssa) {
            str = s;
            ssb.add(str);
        }
        System.out.println("复制后的数据：\n"+ssb);

        System.out.println("\n实体中的体现\n");


        List<NodeInfo> nodeInfos = new ArrayList<>();
        List<CInfos> cInfos = new ArrayList<>();

        //构造赋值
            /*
                List<Integer> list  = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>(list);
            */
        for (NodeInfo nodeInfo : nodeInfos) {
            //注意实体的声明需要在内部，在循环外部声明add方法只会添加最后一次的
            CInfos cInfo = new CInfos();
            BeanUtils.copyProperties(nodeInfo,cInfo);
            cInfo.setStatus("connecting");
            System.out.println("BeanUtils后的单条数据：\n"+JSON.toJSONString(cInfo));
            cInfos.add(cInfo);
        }
        System.out.println("复制后的实体数据\n"+cInfos);



    }

}
