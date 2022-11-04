package com.hctel.oos.ncmount.xc.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class RequestedCapacity {

    @JSONField(name = "total-size")
    private Integer totalSize;

    private Integer cir;

    private Integer pir;

    private Integer cbs;

    private Integer pbs;

    @Override
    public String toString() {
        return "RequestedCapacity{" +
                "totalSize=" + totalSize +
                ", cir=" + cir +
                ", pir=" + pir +
                ", cbs=" + cbs +
                ", pbs=" + pbs +
                '}';
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getCir() {
        return cir;
    }

    public void setCir(Integer cir) {
        this.cir = cir;
    }

    public Integer getPir() {
        return pir;
    }

    public void setPir(Integer pir) {
        this.pir = pir;
    }

    public Integer getCbs() {
        return cbs;
    }

    public void setCbs(Integer cbs) {
        this.cbs = cbs;
    }

    public Integer getPbs() {
        return pbs;
    }

    public void setPbs(Integer pbs) {
        this.pbs = pbs;
    }
}
