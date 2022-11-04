package com.hctel.oos.ncmount.xc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.xc.service.EosConnectionService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/25 9:24
 * @Version 0.1.0
 */
@Service
public class EosConnectionImpl implements EosConnectionService {

    private static final String EOS_CONNECTION = "acc-eos:create-eos-connection";
    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public String createEosConnection(String node, JSONObject input) {
        return odlNetconfChannelUtils.postRequest(node, EOS_CONNECTION, input);
    }
}
