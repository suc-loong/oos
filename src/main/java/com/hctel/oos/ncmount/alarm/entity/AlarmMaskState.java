package com.hctel.oos.ncmount.alarm.entity;

public class AlarmMaskState {
    /**
     * 产生告警的对象标识
     */
    private String objectName;
    /**
     * 事件产生对象类型，如 ME，EQ， PTP 等
     */
    private String alarmCode;
    /**
     * 告警编码
     */
    private String objectType;
    /**
     *  告警抑制状态
     *  TRUE 表示 On(告警被屏蔽);
     *  FALSE 表示 Off(告警不被屏蔽)
     */
    private boolean maskState;


    @Override
    public String toString() {
        return "AlarmMaskState{" +
                "objectName='" + objectName + '\'' +
                ", alarmCode='" + alarmCode + '\'' +
                ", objectType='" + objectType + '\'' +
                ", maskState=" + maskState +
                '}';
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getAlarmCode() {
        return alarmCode;
    }

    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public boolean isMaskState() {
        return maskState;
    }

    public void setMaskState(boolean maskState) {
        this.maskState = maskState;
    }
}
