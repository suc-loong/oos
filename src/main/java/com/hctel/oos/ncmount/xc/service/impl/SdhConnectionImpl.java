package com.hctel.oos.ncmount.xc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.xc.service.SdhConnectionService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/25 11:38
 * @Version 0.1.0
 */
@Service
public class SdhConnectionImpl implements SdhConnectionService {
    private static final String SDH_CONNECTION = "acc-sdh:create-sdh-connection";

    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public String createSdhConnection(String node, JSONObject input) {
        return odlNetconfChannelUtils.postRequest(node,SDH_CONNECTION,input);
    }
}
