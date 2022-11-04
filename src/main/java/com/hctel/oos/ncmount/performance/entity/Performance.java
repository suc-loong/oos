package com.hctel.oos.ncmount.performance.entity;

public class Performance {

    /**
     * 产生性能的对象标识
     */
    private String objectName;
    /**
     * 事件产生对象类型， 如 ME，EQ，PTP 等
     */
    private String objectType;
    /**
     * 周期类型：
     * 1min（只用于EthPerformance 定义的以太网业务性能）,
     * 15min
     * 24h
     */
    private String granularity;
    /**
     * 性能参数名称
     */
    private String pmParameterName;
    /**
     * 数字量性能值
     */
    private Integer digitalPmValue;
    /**
     * 模拟量性能值
     */
    private String analogPmValue;
    /**
     * 性能产生时间
     */
    private String startTime;

    @Override
    public String toString() {
        return "Performance{" +
                "objectName='" + objectName + '\'' +
                ", objectType='" + objectType + '\'' +
                ", granularity='" + granularity + '\'' +
                ", pmParameterName='" + pmParameterName + '\'' +
                ", digitalPmValue=" + digitalPmValue +
                ", analogPmValue='" + analogPmValue + '\'' +
                ", startTime='" + startTime + '\'' +
                '}';
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    public String getPmParameterName() {
        return pmParameterName;
    }

    public void setPmParameterName(String pmParameterName) {
        this.pmParameterName = pmParameterName;
    }

    public Integer getDigitalPmValue() {
        return digitalPmValue;
    }

    public void setDigitalPmValue(Integer digitalPmValue) {
        this.digitalPmValue = digitalPmValue;
    }

    public String getAnalogPmValue() {
        return analogPmValue;
    }

    public void setAnalogPmValue(String analogPmValue) {
        this.analogPmValue = analogPmValue;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
