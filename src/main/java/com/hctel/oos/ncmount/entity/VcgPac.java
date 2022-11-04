package com.hctel.oos.ncmount.entity;

public class VcgPac {

    private String vcType;
    private boolean lcas;
    private Integer holdDff;
    private Integer wtr;
    private boolean tsd;

    @Override
    public String toString() {
        return "VcgPac{" +
                "vcType='" + vcType + '\'' +
                ", lcas=" + lcas +
                ", holdDff=" + holdDff +
                ", wtr=" + wtr +
                ", tsd=" + tsd +
                '}';
    }

    public String getVcType() {
        return vcType;
    }

    public void setVcType(String vcType) {
        this.vcType = vcType;
    }

    public boolean isLcas() {
        return lcas;
    }

    public void setLcas(boolean lcas) {
        this.lcas = lcas;
    }

    public Integer getHoldDff() {
        return holdDff;
    }

    public void setHoldDff(Integer holdDff) {
        this.holdDff = holdDff;
    }

    public Integer getWtr() {
        return wtr;
    }

    public void setWtr(Integer wtr) {
        this.wtr = wtr;
    }

    public boolean isTsd() {
        return tsd;
    }

    public void setTsd(boolean tsd) {
        this.tsd = tsd;
    }
}
