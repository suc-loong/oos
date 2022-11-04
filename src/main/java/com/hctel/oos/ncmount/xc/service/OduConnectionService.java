package com.hctel.oos.ncmount.xc.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/24 16:58
 * @Version 0.1.0
 */
public interface OduConnectionService {

    String createOduConnection(String node, JSONObject input);

    String modifyOduConnectionCapacity(String node,JSONObject input);

}
