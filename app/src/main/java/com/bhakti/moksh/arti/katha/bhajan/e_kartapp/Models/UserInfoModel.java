package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models;

public class UserInfoModel {

    String deviceToken,deviceId;
    int deviceType,type;


    public UserInfoModel(String deviceToken, String deviceId, int deviceType, int type) {
        this.deviceToken = deviceToken;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.type = type;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
