
package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.AuthModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Access {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("expires")
    @Expose
    private String expires;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

}
