package com.hctel.oos.common.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.common.utils.LoadJSONFile;
import com.hctel.oos.common.utils.PrettyJSON;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/26 15:13
 * @Version 0.1.0
 */
@Service
public class LeftTreeViewImpl implements LeftTreeViewService {
    public static final String LABEL = "label";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String VALUE = "value";
    public static final String CHILDREN = "children";
    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    public String isMatch(String str, String sub) {
        int length = sub.length();
        for (int i = 0; i <= (str.length() - sub.length()); i++) {
            // 实际实现是每个字符串做字符比较 ，需要循环子串
            if (str.substring(i, i + sub.length()).equals(sub)) {
                //if (str.substring())
//                System.out.println("匹配开始位置："+i);
//                System.out.println("匹配最末位置："+(i+sub.length()-1));
                return str.substring(i + sub.length(), str.length());

            }
        }
        return null;
    }

    @Override
    public String getLeftTreeView(String node) {
        JSONObject obj = new JSONObject();
        obj.put("name", "");
        obj.put("ptp", "");
        JSONObject eq = new JSONObject();
        JSONObject eqs = new JSONObject();
        eq.put("eq", obj);
        eqs.put("eqs", eq);
        String response = odlNetconfChannelUtils.generalGetRequest(node, eqs);
        JSONObject object = JSONObject.parseObject(response);
        if(object.containsKey("errors")){
            LoadJSONFile loadJSONFile = new LoadJSONFile();
            JSONObject vm = loadJSONFile.getLoadJson("vm-device-template");
            vm.replace("label","vm-device","虚拟设备-"+node);
            vm.put("name",node);
            return vm.toJSONString();
        }
        JSONArray jsonArray = object.getJSONObject("eqs").getJSONArray("eq");
        System.out.println("[DATA]\n" + jsonArray);
        /*
        *    children: [
                {
                    label: "槽道-1 OTN2X8",
                    name:"EQ=/shelf=1/slot=3/subslot=1/EQ=SXC2",
                    value: 3,
                    children: [
                        {label: "端口-1", name:"PTP=/shelf=1/slot=3/subslot=1/port=101",value: 4},
                        {label: "端口-2", name:"PTP=/shelf=1/slot=3/subslot=1/port=102",value: 4},
                        {label: "端口-3", name:"PTP=/shelf=1/slot=3/subslot=1/port=103",value: 4},
                        {label: "端口-4", name:"PTP=/shelf=1/slot=3/subslot=1/port=104",value: 4}
                    ],

                },
            ]
        *
        *
        * */
        JSONArray children_1 = new JSONArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject obj1 = new JSONObject();
            JSONArray children_2 = new JSONArray();
            if (jsonArray.getJSONObject(i).containsKey(NAME)) {
                System.out.println("有name啊");
                String name = jsonArray.getJSONObject(i).getString(NAME);
                System.out.println(isMatch(name, "/EQ="));
                String match = isMatch(name, "/slot=");
                int index = match.indexOf("/");
                String slot = match.substring(0, index);
                String eqName = isMatch(name, "/EQ=");
                obj1.put(LABEL, "槽道-" + slot + " " + eqName);
                obj1.put(TYPE, eqName);
                obj1.put(NAME, name);
                obj1.put(VALUE, 3);
            }
            if (jsonArray.getJSONObject(i).containsKey("ptp")) {
                System.out.println("有ptp啊");
                JSONArray ptp = jsonArray.getJSONObject(i).getJSONArray("ptp");
                for (int i1 = 0; i1 < ptp.size(); i1++) {
                    JSONObject obj2 = new JSONObject();
                    String ptpName = ptp.getString(i1);
                    System.out.println(ptpName);
                    String port = isMatch(ptpName, "/port=");
                    obj2.put(LABEL, "端口-" + port);
                    obj2.put(NAME, ptpName);
                    obj2.put(VALUE, 4);
                    children_2.add(obj2);
                }
                obj1.put(CHILDREN, children_2);
            }
            children_1.add(obj1);
        }
        JSONObject children = new JSONObject();
        children.put(CHILDREN, children_1);


        JSONObject nodeInfo = new JSONObject();

        JSONArray me_children = new JSONArray();

        JSONObject shelf = new JSONObject();
        shelf.put(LABEL,"机架01");
        shelf.put(VALUE,2);
        shelf.put(CHILDREN,children_1);

        me_children.add(shelf);

        nodeInfo.put(LABEL,node);
        nodeInfo.put(NAME,node);
        nodeInfo.put(VALUE,1);
        nodeInfo.put(CHILDREN,me_children);

        System.out.println("新构造的\n" + PrettyJSON.pretty(nodeInfo.toString()));

        return nodeInfo.toJSONString();
    }
}
