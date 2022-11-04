package com.hctel.oos.ncmount.topology.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.hctel.oos.ncmount.topology.entity.BaseNodeInfos;

/**
 * 创建、修改网元设备信息的实体
 *
 * @author wloong
 * @since 2022-03-30 09:04:55
 */
public class NodeInfo  extends BaseNodeInfos {

    private Long id;

    private String type;

    /**
     * node-id、tcp-only、reconnect、reconnect、password、port、host
     * 创建节点必须下发的字段
     */
    @JSONField(name = "netconf-node-topology:tcp-only")
    private boolean tcpOnly;
    @JSONField(name = "netconf-node-topology:reconnect-on-changed-schema")
    private boolean reconnect;

    @Override
    public String toString() {
        return "NodeInfo{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", tcpOnly=" + tcpOnly +
                ", reconnect=" + reconnect +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isTcpOnly() {
        return tcpOnly;
    }

    public void setTcpOnly(boolean tcpOnly) {
        this.tcpOnly = tcpOnly;
    }

    public boolean isReconnect() {
        return reconnect;
    }

    public void setReconnect(boolean reconnect) {
        this.reconnect = reconnect;
    }
}