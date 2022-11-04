package com.hctel.oos.ncmount.entity;

public class SdhPtpPac {
    enum SST{
        STM1,
        STM4,
        STM16,
        STM64,
        STM256
    }

    private SST sdhSignalType;
    private String j0ActualTx;
    private String j0ExpectedRx;

    @Override
    public String toString() {
        return "SdhPtpPac{" +
                "sdhSignalType=" + sdhSignalType +
                ", j0ActualTx='" + j0ActualTx + '\'' +
                ", j0ExpectedRx='" + j0ExpectedRx + '\'' +
                '}';
    }

    public SST getSdhSignalType() {
        return sdhSignalType;
    }

    public void setSdhSignalType(SST sdhSignalType) {
        this.sdhSignalType = sdhSignalType;
    }

    public String getJ0ActualTx() {
        return j0ActualTx;
    }

    public void setJ0ActualTx(String j0ActualTx) {
        this.j0ActualTx = j0ActualTx;
    }

    public String getJ0ExpectedRx() {
        return j0ExpectedRx;
    }

    public void setJ0ExpectedRx(String j0ExpectedRx) {
        this.j0ExpectedRx = j0ExpectedRx;
    }
}
