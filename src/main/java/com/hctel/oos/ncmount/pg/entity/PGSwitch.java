package com.hctel.oos.ncmount.pg.entity;

public class PGSwitch {
    private Integer pgId;
    private String protectionCommand;
    private String protectionDirection;

    @Override
    public String toString() {
        return "PGSwitch{" +
                "pgId=" + pgId +
                ", protectionCommand='" + protectionCommand + '\'' +
                ", protectionDirection='" + protectionDirection + '\'' +
                '}';
    }

    public Integer getPgId() {
        return pgId;
    }

    public void setPgId(Integer pgId) {
        this.pgId = pgId;
    }

    public String getProtectionCommand() {
        return protectionCommand;
    }

    public void setProtectionCommand(String protectionCommand) {
        this.protectionCommand = protectionCommand;
    }

    public String getProtectionDirection() {
        return protectionDirection;
    }

    public void setProtectionDirection(String protectionDirection) {
        this.protectionDirection = protectionDirection;
    }
}
