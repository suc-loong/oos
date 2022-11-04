package com.hctel.oos.ncmount.xc.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/25 9:19
 * @Version 0.1.0
 */
public interface OsuConnectionService {
    String createOsuConnection(String node,JSONObject input);

    String modifyOsuConnectionCapacity(String node, JSONObject input);

    String configOsu2WayDm(String node,JSONObject input);
}
