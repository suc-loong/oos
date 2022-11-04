package com.hctel.oos.ncmount.topology.service;

import com.hctel.oos.ncmount.topology.entity.NodeInfo;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/24 9:40
 * @Version 0.1.0
 */
public interface TopologyMgrServices {

    /**
     * 获取拓扑的所有节点详细信息
     * get
     *
     * @return 所有拓扑节点信息
     */
    String getNodeList();

    /**
     * 获取拓扑的所有节点详细信息
     * get
     *
     * @return 所有拓扑节点信息
     */
    String getAllNode();

    /**
     * 获取指定节点详细信息
     * get
     *
     * @return 指定节点信息
     */
    String getNode(String nodeName);

    /**
     * 设置节点信息，创建设备节点
     * put
     *
     * @param node 节点信息实体
     * @return 操作状态
     */
    Integer configNode(NodeInfo node);

    /**
     * 修改节点下的信息
     * put
     *
     * @param nodeName 节点名称
     * @return 节点信息
     */
    NodeInfo getConfigNode(String nodeName);

    /**
     * 删除节点
     * delete
     *
     * @param nodeName 节点名称
     * @return 操作状态
     */
    Integer deleteNode(String nodeName);

}
