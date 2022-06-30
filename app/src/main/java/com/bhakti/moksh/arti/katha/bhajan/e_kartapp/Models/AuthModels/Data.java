
package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.AuthModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Data {

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("tokens")
    @Expose
    private Tokens tokens;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tokens getTokens() {
        return tokens;
    }

    public void setTokens(Tokens tokens) {
        this.tokens = tokens;
    }

}
