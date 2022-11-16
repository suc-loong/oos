package com.hctel.oos.ncmount.devm.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Description （ctp端口操作）
 *
 * @Author wcloong
 * @Date 2022/11/2 13:39
 * @Version 0.1.0
 */
public interface CtpService {
    /**
     * 获取网元下的所有ctp信息
     *
     * @param node 网元名称
     * @return ctp信息列表
     */
    JSONObject getCtps(String node);

    /**
     * 根据名称获取ctp的内容
     *
     * @param node    网元名称
     * @param ctpName ctp名称
     * @return ctp信息
     */
    JSONObject getCtp(String node, String ctpName);

    /**
     * 获取指定ctp信息
     *
     * @param node 网元名称
     * @param ctp  ctp名称等
     * @return 指定ctp信息
     */
    JSONObject getCtp(String node, JSONObject ctp);

    /**
     * 配置ctp信息
     *
     * @param node 网元名称
     * @param ctp  下发配置ctp端口的信息
     * @return 配置结果
     */
    String configCtp(String node, JSONObject ctp);
}
