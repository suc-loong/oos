package com.hctel.oos.ncmount.devm.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Description（ptp端口操作）
 *
 * @Author wcloong
 * @Date 2022/11/2 13:38
 * @Version 0.1.0
 */
public interface PtpService {
    /**
     * 获取网元下的所有ptp信息
     *
     * @param node 网元名称
     * @return ptp信息列表
     */
    JSONObject getPtps(String node);

    /**
     * 获取指定ptp信息
     *
     * @param node   网元名称
     * @param ptp ptp名称等
     * @return 指定ptp信息
     */
    JSONObject getPtp(String node, JSONObject ptp);

    /**
     * 配置端口信息
     *
     * @param node   网元名称
     * @param ptp 下发配置端口的信息
     * @return 配置结果
     */
    String configPtp(String node, JSONObject ptp);
}
