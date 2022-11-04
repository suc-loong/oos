package com.hctel.oos.ncmount.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (MeInfos)实体类
 *
 * @author makejava
 * @since 2022-10-21 14:16:29
 */
public class MeInfos implements Serializable {
    private static final long serialVersionUID = 697172246053851646L;

    private Integer elmtNo;
    /**
     * 厂家保证唯一性，建议用 MAC 地址
     */
    private String uuid;
    /**
     * 网元名称
     */
    private String elmtName;
    /**
     * 网元厂商名称，长度范围是 1～32
     */
    private String manufacturer;
    /**
     * 网元别名
     */
    private String elmtAlias;
    /**
     * 网元类型
     */
    private Integer elmtType;
    /**
     * 网元型号
     */
    private String elmtSpec;
    /**
     * 软件版本
     */
    private String softwareVersion;
    /**
     * 硬件版本
     */
    private String hardwareVersion;
    /**
     * 网元IP，无则填0.0.0.0
     */
    private String ipAddress;
    /**
     * 网元状态（Installing、Running、Maintenance）
     */
    private Integer status;
    /**
     * 网元/子架供电方式（0:220V AC/ 1:48V DC）
     */
    private Integer powerMode;
    /**
     * 网元/子架风扇工作模式
     */
    private Integer workMode;
    /**
     * 市县、机房
     */
    private String location;
    /**
     * 机架
     */
    private String rack;
    /**
     * 子架
     */
    private String holder;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 父网元号
     */
    private Integer parentElmtNo;
    /**
     * 创建时间
     */
    private Date createDatetime;
    /**
     * 网元创建用户
     */
    private String createUser;
    /**
     * 网元在视图左上角X坐标
     */
    private Integer leftTopx;
    /**
     * 网元在视图左上角Y坐标
     */
    private Integer leftTopy;
    /**
     * 网元备注
     */
    private String elmtRemarks;


    public Integer getElmtNo() {
        return elmtNo;
    }

    public void setElmtNo(Integer elmtNo) {
        this.elmtNo = elmtNo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getElmtName() {
        return elmtName;
    }

    public void setElmtName(String elmtName) {
        this.elmtName = elmtName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getElmtAlias() {
        return elmtAlias;
    }

    public void setElmtAlias(String elmtAlias) {
        this.elmtAlias = elmtAlias;
    }

    public Integer getElmtType() {
        return elmtType;
    }

    public void setElmtType(Integer elmtType) {
        this.elmtType = elmtType;
    }

    public String getElmtSpec() {
        return elmtSpec;
    }

    public void setElmtSpec(String elmtSpec) {
        this.elmtSpec = elmtSpec;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPowerMode() {
        return powerMode;
    }

    public void setPowerMode(Integer powerMode) {
        this.powerMode = powerMode;
    }

    public Integer getWorkMode() {
        return workMode;
    }

    public void setWorkMode(Integer workMode) {
        this.workMode = workMode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRack() {
        return rack;
    }

    public void setRack(String rack) {
        this.rack = rack;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getParentElmtNo() {
        return parentElmtNo;
    }

    public void setParentElmtNo(Integer parentElmtNo) {
        this.parentElmtNo = parentElmtNo;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Integer getLeftTopx() {
        return leftTopx;
    }

    public void setLeftTopx(Integer leftTopx) {
        this.leftTopx = leftTopx;
    }

    public Integer getLeftTopy() {
        return leftTopy;
    }

    public void setLeftTopy(Integer leftTopy) {
        this.leftTopy = leftTopy;
    }

    public String getElmtRemarks() {
        return elmtRemarks;
    }

    public void setElmtRemarks(String elmtRemarks) {
        this.elmtRemarks = elmtRemarks;
    }

}