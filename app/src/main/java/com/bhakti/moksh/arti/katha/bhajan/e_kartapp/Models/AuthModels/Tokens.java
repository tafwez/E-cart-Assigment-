
package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.AuthModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tokens {

    @SerializedName("access")
    @Expose
    private Access access;
    @SerializedName("refresh")
    @Expose
    private Refresh refresh;

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public Refresh getRefresh() {
        return refresh;
    }

    public void setRefresh(Refresh refresh) {
        this.refresh = refresh;
    }

}
