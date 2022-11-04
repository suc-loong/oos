package com.hctel.oos.ncmount.xc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.xc.service.OsuConnectionService;
import org.springframework.stereotype.Service;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/25 11:39
 * @Version 0.1.0
 */
@Service
public class OsuConnectionImpl implements OsuConnectionService {

    @Override
    public String createOsuConnection(String node, JSONObject input) {
        return null;
    }

    @Override
    public String modifyOsuConnectionCapacity(String node, JSONObject input) {
        return null;
    }

    @Override
    public String configOsu2WayDm(String node, JSONObject input) {
        return null;
    }
}
