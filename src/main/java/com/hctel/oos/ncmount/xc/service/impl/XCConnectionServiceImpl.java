package com.hctel.oos.ncmount.xc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.xc.service.XCConnectionService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.hctel.oos.netconf.utils.ODLNetconfChannelUtils.config;
import static com.hctel.oos.netconf.utils.ODLNetconfChannelUtils.operational;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 15:44
 * @Version 0.1.0
 */
@Service
public class XCConnectionServiceImpl implements XCConnectionService {
    private static final String CONNECTION_MODULE = "acc-connection:connections";
    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public JSONObject getConnections(String node) {
        return odlNetconfChannelUtils.getRequest(operational,node,CONNECTION_MODULE);
    }

    @Override
    public JSONObject getConnection(String node, String connName) {
        String module = "acc-connection:connections/connection/"+connName;
        return odlNetconfChannelUtils.getRequest(operational,node,module);
    }

    @Override
    public JSONObject getConnection(String node, JSONObject connection) {
        JSONObject connections = new JSONObject();
        connections.put("connections",connection);
        return JSONObject.parseObject(odlNetconfChannelUtils.generalGetRequest(node,connections));
    }

}
