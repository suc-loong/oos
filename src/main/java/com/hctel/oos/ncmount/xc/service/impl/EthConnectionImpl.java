package com.hctel.oos.ncmount.xc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.xc.service.EthConnectionService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/25 11:36
 * @Version 0.1.0
 */
@Service
public class EthConnectionImpl implements EthConnectionService {
    private static final String ETH_CONNECTION = "acc-eth:create-eth-connection";
    private static final String ETH_2_CONNECTION = "acc-eth:create-eth-to-eth-connection";

    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public String createEthConnection(String node, JSONObject input) {
        return odlNetconfChannelUtils.postRequest(node, ETH_CONNECTION, input);
    }

    @Override
    public String createEth2EthConnection(String node, JSONObject input) {
        return odlNetconfChannelUtils.postRequest(node, ETH_2_CONNECTION, input);
    }
}
