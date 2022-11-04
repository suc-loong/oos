package com.hctel.oos.ncmount.topology.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.hctel.oos.ncmount.topology.entity.BaseNodeInfos;

public class CInfos extends BaseNodeInfos {
    /**
     * node-id、port、host、status
     * 判断连接状态的返回的字段
     */
    @JSONField(name = "netconf-node-topology:connection-status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CInfos{" +
                "status='" + status + '\'' +
                '}';
    }
}
