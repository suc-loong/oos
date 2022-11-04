package com.hctel.oos.ncmount.xc.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class BaseNNI {

    //"nni-ptp-name": "PTP=/shelf=1/slot=6/subslot=1/port=108",
    //"nni-ts-detail": "8-80",
    //"adaptation-type": "ODUj21",
    //"client-signal-type": "ODU0",
    //"switch-capability": "ietf-otn-types:ODU2"


    @JSONField(name = "nni-ptp-name")
    private String name;

    @JSONField(name = "nni-ts-detail")
    private String detail;

    //枚举类型
    @JSONField(name = "adaptation-type")
    private String adaptationType;

    @JSONField(name = "client-signal-type")
    private String signalType;

    @JSONField(name = "switch-capability")
    private String switchCapability;

    @Override
    public String toString() {
        return "BaseNNI{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", adaptationType='" + adaptationType + '\'' +
                ", signalType='" + signalType + '\'' +
                ", switchCapability='" + switchCapability + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAdaptationType() {
        return adaptationType;
    }

    public void setAdaptationType(String adaptationType) {
        this.adaptationType = adaptationType;
    }

    public String getSignalType() {
        return signalType;
    }

    public void setSignalType(String signalType) {
        this.signalType = signalType;
    }

    public String getSwitchCapability() {
        return switchCapability;
    }

    public void setSwitchCapability(String switchCapability) {
        this.switchCapability = switchCapability;
    }
}
