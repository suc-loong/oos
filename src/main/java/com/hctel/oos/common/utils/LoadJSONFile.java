package com.hctel.oos.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class LoadJSONFile {


    public String jsonPath(String name) {
        String property = System.getProperty("user.dir");
        String path = property + "/src/main/resources/json/"+name+".json";
        return path;
    }

    //读取json文件
    public String readJsonFile(String Filename /*传文件的路径*/) {
        String jsonStr = "";
        try {
            File jsonFile = new File(Filename);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
//            System.out.println(jsonStr.getClass().getName());
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject getLoadJson(String name) {
        String strPath = jsonPath(name);
        System.out.println("file path : " + strPath);
        String s = readJsonFile(strPath);
        System.out.println("json : \n" + PrettyJSON.pretty(s));
        return (JSONObject) JSON.parse(s);
    }
}
