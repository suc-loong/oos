package com.hctel.oos.ncmount.entity;

public class EthPtpPac {
    enum WorkingMode {
        Auto,
        MFullDuplex100,
        MFullDuplex1000,
        GEFullDuplex10
    }

    private WorkingMode currentWorkingMode;
    private Integer currentMtu;
    private boolean pauseControl;
    private String macAddress;
    private boolean lldpEnable;

    @Override
    public String toString() {
        return "EthPtpPac{" +
                "currentWorkingMode=" + currentWorkingMode +
                ", currentMtu=" + currentMtu +
                ", pauseControl=" + pauseControl +
                ", macAddress='" + macAddress + '\'' +
                ", lldpEnable=" + lldpEnable +
                '}';
    }

    public WorkingMode getCurrentWorkingMode() {
        return currentWorkingMode;
    }

    public void setCurrentWorkingMode(WorkingMode currentWorkingMode) {
        this.currentWorkingMode = currentWorkingMode;
    }

    public Integer getCurrentMtu() {
        return currentMtu;
    }

    public void setCurrentMtu(Integer currentMtu) {
        this.currentMtu = currentMtu;
    }

    public boolean isPauseControl() {
        return pauseControl;
    }

    public void setPauseControl(boolean pauseControl) {
        this.pauseControl = pauseControl;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public boolean isLldpEnable() {
        return lldpEnable;
    }

    public void setLldpEnable(boolean lldpEnable) {
        this.lldpEnable = lldpEnable;
    }
}
