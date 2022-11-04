package com.hctel.oos.ncmount.pg.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 15:12
 * @Version 0.1.0
 */
public interface LagPGService {

    JSONObject getLagPGs(String node);

    JSONObject getLagPG(String node,String pgId);

    String configLagPG(String node, JSONObject lagPG);

}
