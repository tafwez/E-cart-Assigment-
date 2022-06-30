
package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.AuthModels;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("isVerifyMobileOtp")
    @Expose
    private Boolean isVerifyMobileOtp;
    @SerializedName("isVerifyEmailOtp")
    @Expose
    private Boolean isVerifyEmailOtp;
    @SerializedName("isSignup")
    @Expose
    private Boolean isSignup;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("deviceToken")
    @Expose
    private String deviceToken;
    @SerializedName("deviceId")
    @Expose
    private String deviceId;
    @SerializedName("deviceType")
    @Expose
    private Integer deviceType;
    @SerializedName("isPushNotification")
    @Expose
    private Boolean isPushNotification;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("isDelete")
    @Expose
    private Integer isDelete;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("emailOTP")
    @Expose
    private Integer emailOTP;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("mobileOTP")
    @Expose
    private Integer mobileOTP;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;

    public Boolean getIsVerifyMobileOtp() {
        return isVerifyMobileOtp;
    }

    public void setIsVerifyMobileOtp(Boolean isVerifyMobileOtp) {
        this.isVerifyMobileOtp = isVerifyMobileOtp;
    }

    public Boolean getIsVerifyEmailOtp() {
        return isVerifyEmailOtp;
    }

    public void setIsVerifyEmailOtp(Boolean isVerifyEmailOtp) {
        this.isVerifyEmailOtp = isVerifyEmailOtp;
    }

    public Boolean getIsSignup() {
        return isSignup;
    }

    public void setIsSignup(Boolean isSignup) {
        this.isSignup = isSignup;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Boolean getIsPushNotification() {
        return isPushNotification;
    }

    public void setIsPushNotification(Boolean isPushNotification) {
        this.isPushNotification = isPushNotification;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmailOTP() {
        return emailOTP;
    }

    public void setEmailOTP(Integer emailOTP) {
        this.emailOTP = emailOTP;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getMobileOTP() {
        return mobileOTP;
    }

    public void setMobileOTP(Integer mobileOTP) {
        this.mobileOTP = mobileOTP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
