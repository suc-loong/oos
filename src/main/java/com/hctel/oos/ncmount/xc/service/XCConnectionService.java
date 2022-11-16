package com.hctel.oos.ncmount.xc.service;

import com.alibaba.fastjson.JSONObject;

import static com.hctel.oos.netconf.utils.ODLNetconfChannelUtils.config;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 15:43
 * @Version 0.1.0
 */
public interface XCConnectionService {

    /**
     * 查询全部交叉连接
     *
     * @param node 网元名称
     * @return 交叉连接列表
     */
    JSONObject getConnections(String node);

    /**
     * 查询指定名称的交叉连接
     *
     * @param node     网元名称
     * @param connName 连接名称
     * @return 交叉信息
     */
    JSONObject getConnection(String node, String connName);

    /**
     * 查询指定内容的交叉连接
     *
     * @param node       网元名称
     * @param connection 交叉连接信息
     * @return 符合条件的交叉信息（列表）
     */
    JSONObject getConnection(String node, JSONObject connection);

    /**
     * 修改交叉连接的配置
     * 例如：修改名称（service-label）
     * @param node 网元名称
     * @param connection 下发修改的信息
     * @return 操作状态
     */
    String configConnection(String node,JSONObject connection);

    /**
     * 删除指定的交叉连接
     * @param node 网元名称
     * @param name 连接名称
     * @return 操作状态
     */
    String deleteConnection(String node,String name);
}
