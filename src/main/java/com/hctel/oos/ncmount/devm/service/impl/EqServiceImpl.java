package com.hctel.oos.ncmount.devm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.devm.service.EqService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/3 10:51
 * @Version 0.1.0
 */
@Service
public class EqServiceImpl implements EqService {
    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public JSONObject getEqs(String node) {
        return odlNetconfChannelUtils.getRequest(ODLNetconfChannelUtils.operational,node,"acc-devm:eqs");
    }

    @Override
    public JSONObject getEq(String node, String eqName) {
        return null;
    }

    @Override
    public JSONObject getEq(String node, JSONObject eq) {
        JSONObject eqs = new JSONObject();
        eqs.put("eqs",eq);
        return JSONObject.parseObject(odlNetconfChannelUtils.generalGetRequest(node,eqs));
    }

    @Override
    public String resetEq(String node, JSONObject input) {
        return odlNetconfChannelUtils.postRequest(node,"acc-devm:reset",input);
    }
}
