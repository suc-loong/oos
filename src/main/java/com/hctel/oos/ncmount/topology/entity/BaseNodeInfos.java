package com.hctel.oos.ncmount.topology.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * (BaseNodeInfos)实体类
 * 基类节点
 *
 * @author wloong
 * @since 2022-03-28 15:44:52
 */
public class BaseNodeInfos {

    @JSONField(name = "node-id")
    private String name;

    @JSONField(name = "netconf-node-topology:host")
    private String host;

    @JSONField(name = "netconf-node-topology:port")
    private Long port;

    @JSONField(name = "netconf-node-topology:username")
    private String username;

    @JSONField(name = "netconf-node-topology:password")
    private String password;

    @Override
    public String toString() {
        return "BaseNodeInfos{" +
                "name='" + name + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}