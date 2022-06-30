
package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.Products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ShopId {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("shopTitle")
    @Expose
    private String shopTitle;
    @SerializedName("shopNickName")
    @Expose
    private String shopNickName;
    @SerializedName("averageTime")
    @Expose
    private String averageTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public String getShopNickName() {
        return shopNickName;
    }

    public void setShopNickName(String shopNickName) {
        this.shopNickName = shopNickName;
    }

    public String getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(String averageTime) {
        this.averageTime = averageTime;
    }

}
