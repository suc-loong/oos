package com.hctel.oos.ncmount.xc.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/24 17:01
 * @Version 0.1.0
 */
public interface EosConnectionService {

    /**
     * 创建eos交叉连接
     *
     * @param node  网元名称
     * @param input 下发报文
     * @return 创建的服务
     */
    String createEosConnection(String node, JSONObject input);

}
