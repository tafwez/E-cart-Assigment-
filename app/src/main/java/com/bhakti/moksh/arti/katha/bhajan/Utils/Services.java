package com.bhakti.moksh.arti.katha.bhajan.Utils;

import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.AuthModels.AuthModels;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.CategoryList.CategoryListModel;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.Products.Products;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.UserInfoModel;
import com.google.gson.JsonObject;


import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface Services {


    @Headers("Authorization:Basic bG9jYWx2b2NhbDpsb2NhbHZvY2FsQDEyMzQ1")
    @POST("user/auth/guest")
    Call<AuthModels> AuthUser(@Body UserInfoModel locationPost);


    @Headers("Authorization:Basic bG9jYWx2b2NhbDpsb2NhbHZvY2FsQDEyMzQ1")
    @GET("category/list/dropdown")
    Call<CategoryListModel> GetDropDownTitle();




    @GET("product")
    Call<Products> getProduct(@Query("page") String page,
                                  @Query("limit") String limit,
                                  @Query("sortBy") String shortby,
                                  @Query("searchBy") String searchBy,
                                  @Query("shopId") String shopId,
                                  @Query("categoryId") String categoryId,
                                  @Header("Authorization") String authHeader);





}
