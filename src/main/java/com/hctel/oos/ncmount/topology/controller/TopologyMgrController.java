package com.hctel.oos.ncmount.topology.controller;

import com.hctel.oos.ncmount.topology.entity.NodeInfo;
import com.hctel.oos.ncmount.topology.service.TopologyMgrServices;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 * 拓扑层下的操作接口
 *
 * @Author wcloong
 * @Date 2022/10/24 9:39
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology")
public class TopologyMgrController {

    @Resource
    private TopologyMgrServices topologyMgrServices;

    /**
     * 获取拓扑的所有节点详细信息
     * 主要是连接状态的获取
     * 该字段应该对应前端设备的连接状态实时刷新，并设置到每一个设备上
     *
     * @return 所有拓扑下网元信息
     */
    @GetMapping(params= {"content=all"})
    public String getNodeList() {
        return topologyMgrServices.getAllNode();
    }

    @GetMapping
    public String getAllNode() {
        return topologyMgrServices.getAllNode();
    }

    @GetMapping("/node/{node}")
    public String getNode(@PathVariable String node) {
        return topologyMgrServices.getNode(node);
    }

    /**
     * 获取已存在的网元的配置信息
     * 便于修改使用
     *
     * @param node 网元名称
     * @return 指定网元配置信息
     */
    @GetMapping(value = "/node/{node}",params = {"content=config"})
    public NodeInfo getConfigNode(@PathVariable String node) {
        return topologyMgrServices.getConfigNode(node);
    }

    /**
     * 设置网元信息，创建网元设备
     * 节点id是必须字段
     *
     * @param node 网元名称
     * @return 操作状态
     */
    @RequestMapping(value = "/node/{node}",method = RequestMethod.PUT)
    public Integer configNode(@RequestBody NodeInfo nodeInfo,@PathVariable String node) {
        return topologyMgrServices.configNode(nodeInfo);
    }

    /**
     * 删除网元
     *
     * @param node 网元名称
     * @return 操作状态
     */
    @DeleteMapping("/node/{node}")
    public Integer deleteNode(@PathVariable String node) {
        return topologyMgrServices.deleteNode(node);
    }
}
