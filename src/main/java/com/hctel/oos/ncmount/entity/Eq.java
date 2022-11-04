package com.hctel.oos.ncmount.entity;

public class Eq {
    private String epName;
    private String resetType;

    @Override
    public String toString() {
        return "Eq{" +
                "epName='" + epName + '\'' +
                ", resetType='" + resetType + '\'' +
                '}';
    }

    public String getEpName() {
        return epName;
    }

    public void setEpName(String epName) {
        this.epName = epName;
    }

    public String getResetType() {
        return resetType;
    }

    public void setResetType(String resetType) {
        this.resetType = resetType;
    }
}
