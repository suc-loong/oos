package com.hctel.oos.ncmount.xc.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description （odu交叉的实体类）
 *
 * @Author wcloong
 * @Date 2022/10/25 9:24
 * @Version 0.1.0
 */
public class OduConnection {
    @JSONField(name = "connection-name")
    private String connectionName;

    @JSONField(name = "service-type")
    private String serviceType;

    @JSONField(name = "layer-protocol-name")
    private String layerProtocolName;

    @JSONField(name = "requested-capacity")
    private RequestedCapacity requestedCapacity;

    @JSONField(name = "client-side-nni")
    private BaseNNI clientNNI;

    @JSONField(name = "primary-nni-1")
    private BaseNNI primaryNNI;

    @JSONField(name = "secondary-nni-1")
    private BaseNNI secondaryNNI;

    @Override
    public String toString() {
        return "OduConnection{" +
                "connectionName='" + connectionName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", layerProtocolName='" + layerProtocolName + '\'' +
                ", requestedCapacity=" + requestedCapacity +
                ", clientNNI=" + clientNNI +
                ", primaryNNI=" + primaryNNI +
                ", secondaryNNI=" + secondaryNNI +
                '}';
    }

    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getLayerProtocolName() {
        return layerProtocolName;
    }

    public void setLayerProtocolName(String layerProtocolName) {
        this.layerProtocolName = layerProtocolName;
    }

    public RequestedCapacity getRequestedCapacity() {
        return requestedCapacity;
    }

    public void setRequestedCapacity(RequestedCapacity requestedCapacity) {
        this.requestedCapacity = requestedCapacity;
    }

    public BaseNNI getClientNNI() {
        return clientNNI;
    }

    public void setClientNNI(BaseNNI clientNNI) {
        this.clientNNI = clientNNI;
    }

    public BaseNNI getPrimaryNNI() {
        return primaryNNI;
    }

    public void setPrimaryNNI(BaseNNI primaryNNI) {
        this.primaryNNI = primaryNNI;
    }

    public BaseNNI getSecondaryNNI() {
        return secondaryNNI;
    }

    public void setSecondaryNNI(BaseNNI secondaryNNI) {
        this.secondaryNNI = secondaryNNI;
    }
}
