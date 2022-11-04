package com.hctel.oos.ncmount.xc.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/24 16:57
 * @Version 0.1.0
 */
public interface SdhConnectionService {

    /**
     * 创建sdh连接
     * @param node 网元名称
     * @param input 下发报文
     * @return 返回创建服务
     */
    String createSdhConnection(String node, JSONObject input);
}
