package com.hctel.oos.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/12/30 16:17
 * @Version 0.1.0
 */
@Service
public class NetconfCommonAPIImpl implements NetconfCommonAPIService{

    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public JSONObject generalGetRequest(String node, JSONObject input) {
        return JSONObject.parseObject(odlNetconfChannelUtils.generalGetRequest(node, input));
    }

    @Override
    public JSONObject generalGetConfigRequest(String node, JSONObject input) {
        return null;
    }

    @Override
    public JSONObject generalEditConfigRequest(String node, JSONObject input) {
        return JSONObject.parseObject(odlNetconfChannelUtils.generalEditConfigRequest(node, input));
    }

    @Override
    public JSONObject generalCopyConfigRequest(String node, JSONObject input) {
        return null;
    }
}
