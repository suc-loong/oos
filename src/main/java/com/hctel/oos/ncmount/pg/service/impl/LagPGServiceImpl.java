package com.hctel.oos.ncmount.pg.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.pg.service.LagPGService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 15:12
 * @Version 0.1.0
 */
@Service
public class LagPGServiceImpl implements LagPGService {
    private static final String LAG_PG_MODULE = "acc-protection-group:lagPGs";

    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public JSONObject getLagPGs(String node) {
        return odlNetconfChannelUtils.getRequest(ODLNetconfChannelUtils.operational,node);
    }

    @Override
    public JSONObject getLagPG(String node, String pgId) {
        String module = LAG_PG_MODULE + "/lagPG/"+pgId;
        return odlNetconfChannelUtils.getRequest(ODLNetconfChannelUtils.operational,node,module);
    }

    @Override
    public String configLagPG(String node, JSONObject lagPG) {
        String pgId = lagPG.getJSONObject("lagPG").getString("lag-id");
        String module = LAG_PG_MODULE + "/lagPG/"+pgId;
        return odlNetconfChannelUtils.putRequest(node,module,lagPG).toString();
    }
}
