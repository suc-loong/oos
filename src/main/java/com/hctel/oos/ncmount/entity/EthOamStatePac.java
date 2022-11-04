package com.hctel.oos.ncmount.entity;

public class EthOamStatePac {

    enum ethOamMeasureEnable {
        TRUE, FALSE, NULL
    }

    //默认值为false
    /**
     * 示双向时延测量使能
     */
    private ethOamMeasureEnable dmState;
    /**
     * 发送/接收流量测量使能
     */
    private ethOamMeasureEnable tmState;
    /**
     * 丢包率测量使能
     */
    private ethOamMeasureEnable lmState;
    /**
     * 连通性监测使能
     */
    private ethOamMeasureEnable ccState;

    @Override
    public String toString() {
        return "EthOamStatePac{" +
                "dmState=" + dmState +
                ", tmState=" + tmState +
                ", lmState=" + lmState +
                ", ccState=" + ccState +
                '}';
    }

    public ethOamMeasureEnable getDmState() {
        return dmState;
    }

    public void setDmState(ethOamMeasureEnable dmState) {
        this.dmState = dmState;
    }

    public ethOamMeasureEnable getTmState() {
        return tmState;
    }

    public void setTmState(ethOamMeasureEnable tmState) {
        this.tmState = tmState;
    }

    public ethOamMeasureEnable getLmState() {
        return lmState;
    }

    public void setLmState(ethOamMeasureEnable lmState) {
        this.lmState = lmState;
    }

    public ethOamMeasureEnable getCcState() {
        return ccState;
    }

    public void setCcState(ethOamMeasureEnable ccState) {
        this.ccState = ccState;
    }
}
