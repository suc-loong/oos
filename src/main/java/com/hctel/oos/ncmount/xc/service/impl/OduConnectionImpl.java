package com.hctel.oos.ncmount.xc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.xc.service.OduConnectionService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OduConnectionImpl implements OduConnectionService {
    private static final String ODU_CONNECTION = "acc-otn:create-odu-connection";
    private static final String ODU_CAPACITY = "acc-otn:modify-odu-connection-capacity";

    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public String createOduConnection(String node, JSONObject obj) {
        return odlNetconfChannelUtils.postRequest(node,ODU_CONNECTION,obj);
    }

    @Override
    public String modifyOduConnectionCapacity(String node, JSONObject input) {
        return odlNetconfChannelUtils.postRequest(node,ODU_CAPACITY, input);
    }
}
