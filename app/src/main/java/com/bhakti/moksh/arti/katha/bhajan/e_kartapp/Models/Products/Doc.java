
package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.Products;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doc {

    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("searchStrings")
    @Expose
    private List<Object> searchStrings = null;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("isDelete")
    @Expose
    private Integer isDelete;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("productTitle")
    @Expose
    private String productTitle;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("subCategory")
    @Expose
    private SubCategory subCategory;
    @SerializedName("vendorId")
    @Expose
    private VendorId vendorId;
    @SerializedName("shopId")
    @Expose
    private ShopId shopId;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("__v")
    @Expose
    private Integer v;


    @SerializedName("id")
    @Expose
    private String id;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Object> getSearchStrings() {
        return searchStrings;
    }

    public void setSearchStrings(List<Object> searchStrings) {
        this.searchStrings = searchStrings;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public VendorId getVendorId() {
        return vendorId;
    }

    public void setVendorId(VendorId vendorId) {
        this.vendorId = vendorId;
    }

    public ShopId getShopId() {
        return shopId;
    }

    public void setShopId(ShopId shopId) {
        this.shopId = shopId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }


    @Override
    public String toString() {
        return "Doc{" +
                "_id='" + _id + '\'' +
                ", images=" + images +
                ", price=" + price +
                ", searchStrings=" + searchStrings +
                ", status=" + status +
                ", isDelete=" + isDelete +
                ", quantity=" + quantity +
                ", productTitle='" + productTitle + '\'' +
                ", category=" + category +
                ", subCategory=" + subCategory +
                ", vendorId=" + vendorId +
                ", shopId=" + shopId +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", v=" + v +
                ", id='" + id + '\'' +
                '}';
    }
}
