package com.hctel.oos.ncmount.xc.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/25 14:32
 * @Version 0.1.0
 */
public class InputJSONObject {

    private static final String INPUT = "input";

    public InputJSONObject() {
    }

    public static JSONObject content(Object obj){
        JSONObject object = new JSONObject();
        object.put(INPUT,obj);
        return object;
    }
}
