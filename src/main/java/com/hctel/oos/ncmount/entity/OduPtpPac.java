package com.hctel.oos.ncmount.entity;

public class OduPtpPac {

    /**
     * 该端口对应的时隙占用情况。该属 性采用“SS-BB”的形式。
     * 该形式用于表明该端口资源所对应的特定资源。
     * SS 表示bit位的个数，采用10进制；
     * BB 是一个bit表，表示每一个时隙的具体信息（从 HSB 开始， 1表示该时隙占用，0表示该时隙可用），
     * 采用16进制，bit位不足8比特倍数低位补0。
     * 举例：10G OTU2中的第一 个 ODU0 时隙被占用表示为8-80。
     */
    private String tsDetail;
    /**
     * SM 实际发送开销
     */
    private String sMTrailTraceActualTx;
    /**
     * SM 实际接收开销
     */
    private String sMTrailTraceExpectedRx;
    /**
     * PM 实际发送开销
     */
    private String pMTrailTraceActualTx;
    /**
     * PM 实际接收开销
     */
    private String pMTrailTraceExpectedRx;

    @Override
    public String toString() {
        return "OduPtpPac{" +
                "tsDetail='" + tsDetail + '\'' +
                ", sMTrailTraceActualTx='" + sMTrailTraceActualTx + '\'' +
                ", sMTrailTraceExpectedRx='" + sMTrailTraceExpectedRx + '\'' +
                ", pMTrailTraceActualTx='" + pMTrailTraceActualTx + '\'' +
                ", pMTrailTraceExpectedRx='" + pMTrailTraceExpectedRx + '\'' +
                '}';
    }

    public String getTsDetail() {
        return tsDetail;
    }

    public void setTsDetail(String tsDetail) {
        this.tsDetail = tsDetail;
    }

    public String getsMTrailTraceActualTx() {
        return sMTrailTraceActualTx;
    }

    public void setsMTrailTraceActualTx(String sMTrailTraceActualTx) {
        this.sMTrailTraceActualTx = sMTrailTraceActualTx;
    }

    public String getsMTrailTraceExpectedRx() {
        return sMTrailTraceExpectedRx;
    }

    public void setsMTrailTraceExpectedRx(String sMTrailTraceExpectedRx) {
        this.sMTrailTraceExpectedRx = sMTrailTraceExpectedRx;
    }

    public String getpMTrailTraceActualTx() {
        return pMTrailTraceActualTx;
    }

    public void setpMTrailTraceActualTx(String pMTrailTraceActualTx) {
        this.pMTrailTraceActualTx = pMTrailTraceActualTx;
    }

    public String getpMTrailTraceExpectedRx() {
        return pMTrailTraceExpectedRx;
    }

    public void setpMTrailTraceExpectedRx(String pMTrailTraceExpectedRx) {
        this.pMTrailTraceExpectedRx = pMTrailTraceExpectedRx;
    }
}
