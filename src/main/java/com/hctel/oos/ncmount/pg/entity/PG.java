package com.hctel.oos.ncmount.pg.entity;

public class PG {

    private Integer pgId;
    private String protectionType;
    private String switchType;
    private String reversionMode;
    private String sdTrigger;
    private String waitToRestoreTime;
    private String holdOff;
    private Integer primaryPort;
    private Integer secondaryPort;


    @Override
    public String toString() {
        return "PG{" +
                "pgId=" + pgId +
                ", protectionType='" + protectionType + '\'' +
                ", switchType='" + switchType + '\'' +
                ", reversionMode='" + reversionMode + '\'' +
                ", sdTrigger='" + sdTrigger + '\'' +
                ", waitToRestoreTime='" + waitToRestoreTime + '\'' +
                ", holdOff='" + holdOff + '\'' +
                ", primaryPort=" + primaryPort +
                ", secondaryPort=" + secondaryPort +
                '}';
    }

    public Integer getPgId() {
        return pgId;
    }

    public void setPgId(Integer pgId) {
        this.pgId = pgId;
    }

    public String getProtectionType() {
        return protectionType;
    }

    public void setProtectionType(String protectionType) {
        this.protectionType = protectionType;
    }

    public String getSwitchType() {
        return switchType;
    }

    public void setSwitchType(String switchType) {
        this.switchType = switchType;
    }

    public String getReversionMode() {
        return reversionMode;
    }

    public void setReversionMode(String reversionMode) {
        this.reversionMode = reversionMode;
    }

    public String getSdTrigger() {
        return sdTrigger;
    }

    public void setSdTrigger(String sdTrigger) {
        this.sdTrigger = sdTrigger;
    }

    public String getWaitToRestoreTime() {
        return waitToRestoreTime;
    }

    public void setWaitToRestoreTime(String waitToRestoreTime) {
        this.waitToRestoreTime = waitToRestoreTime;
    }

    public String getHoldOff() {
        return holdOff;
    }

    public void setHoldOff(String holdOff) {
        this.holdOff = holdOff;
    }

    public Integer getPrimaryPort() {
        return primaryPort;
    }

    public void setPrimaryPort(Integer primaryPort) {
        this.primaryPort = primaryPort;
    }

    public Integer getSecondaryPort() {
        return secondaryPort;
    }

    public void setSecondaryPort(Integer secondaryPort) {
        this.secondaryPort = secondaryPort;
    }
}
