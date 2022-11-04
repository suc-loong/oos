package com.hctel.oos.ncmount.xc.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/24 16:57
 * @Version 0.1.0
 */
public interface EthConnectionService {

    String createEthConnection(String node,JSONObject input);

    String createEth2EthConnection(String node, JSONObject input);
}
