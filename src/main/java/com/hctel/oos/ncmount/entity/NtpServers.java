package com.hctel.oos.ncmount.entity;

public class NtpServers {

    private String name;
    private String ipAddress;
    private String port;
    private String ntpVersion;

    @Override
    public String toString() {
        return "NtpServers{" +
                "name='" + name + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", port='" + port + '\'' +
                ", ntpVersion='" + ntpVersion + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getNtpVersion() {
        return ntpVersion;
    }

    public void setNtpVersion(String ntpVersion) {
        this.ntpVersion = ntpVersion;
    }
}
