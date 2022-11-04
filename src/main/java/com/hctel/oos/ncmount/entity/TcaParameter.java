package com.hctel.oos.ncmount.entity;

public class TcaParameter {
    private String objectName;
    private String pmParameterName;
    private String granularity;
    private Integer thresholdType;
    private String objectType;
    private String thresholdValue;
    @Override
    public String toString() {
        return "TcaParameter{" +
                "objectName='" + objectName + '\'' +
                ", pmParameterName='" + pmParameterName + '\'' +
                ", granularity='" + granularity + '\'' +
                ", thresholdType=" + thresholdType +
                ", objectType='" + objectType + '\'' +
                ", thresholdValue='" + thresholdValue + '\'' +
                '}';
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getPmParameterName() {
        return pmParameterName;
    }

    public void setPmParameterName(String pmParameterName) {
        this.pmParameterName = pmParameterName;
    }

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    public Integer getThresholdType() {
        return thresholdType;
    }

    public void setThresholdType(Integer thresholdType) {
        this.thresholdType = thresholdType;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(String thresholdValue) {
        this.thresholdValue = thresholdValue;
    }
}
