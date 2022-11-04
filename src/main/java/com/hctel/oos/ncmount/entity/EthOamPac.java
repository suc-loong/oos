package com.hctel.oos.ncmount.entity;

public class EthOamPac {
    private Integer mepId;
    private Integer remoteMepId;
    private Integer megId;
    private String mdName;
    private Integer mel;
    private String ccInterval;
    private String lmInterval;
    private String dmInterval;

    @Override
    public String toString() {
        return "OAMConfig{" +
                "mepId=" + mepId +
                ", remoteMepId=" + remoteMepId +
                ", megId=" + megId +
                ", mdName='" + mdName + '\'' +
                ", mel=" + mel +
                ", ccInterval='" + ccInterval + '\'' +
                ", lmInterval='" + lmInterval + '\'' +
                ", dmInterval='" + dmInterval + '\'' +
                '}';
    }

    public Integer getMepId() {
        return mepId;
    }

    public void setMepId(Integer mepId) {
        this.mepId = mepId;
    }

    public Integer getRemoteMepId() {
        return remoteMepId;
    }

    public void setRemoteMepId(Integer remoteMepId) {
        this.remoteMepId = remoteMepId;
    }

    public Integer getMegId() {
        return megId;
    }

    public void setMegId(Integer megId) {
        this.megId = megId;
    }

    public String getMdName() {
        return mdName;
    }

    public void setMdName(String mdName) {
        this.mdName = mdName;
    }

    public Integer getMel() {
        return mel;
    }

    public void setMel(Integer mel) {
        this.mel = mel;
    }

    public String getCcInterval() {
        return ccInterval;
    }

    public void setCcInterval(String ccInterval) {
        this.ccInterval = ccInterval;
    }

    public String getLmInterval() {
        return lmInterval;
    }

    public void setLmInterval(String lmInterval) {
        this.lmInterval = lmInterval;
    }

    public String getDmInterval() {
        return dmInterval;
    }

    public void setDmInterval(String dmInterval) {
        this.dmInterval = dmInterval;
    }
}
