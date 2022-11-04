package com.hctel.oos.ncmount.devm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.devm.service.CtpService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 13:42
 * @Version 0.1.0
 */
@Service
public class CtpServiceImpl implements CtpService {
    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public JSONObject getCtps(String node) {
        return null;
    }

    @Override
    public JSONObject getCtp(String node, JSONObject ctp) {
        JSONObject ctps = new JSONObject();
        ctps.put("ctps",ctp);
        return JSONObject.parseObject(odlNetconfChannelUtils.generalGetRequest(node, ctps));
    }

    @Override
    public String configCtp(String node, JSONObject ctp) {
        JSONObject ctps = new JSONObject();
        ctps.put("ctps",ctp);
        return odlNetconfChannelUtils.generalEditConfigRequest(node, ctp);
    }
}
