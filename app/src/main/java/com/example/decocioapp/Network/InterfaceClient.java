package com.example.decocioapp.Network;

import com.example.decocioapp.Model.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceClient {
    @FormUrlEncoded
    @POST("exec")
    Call<ResponseLogin> loginUser(
            @Field(value = "sheetName", encoded = true)String SheetName,
            @Field(value = "action", encoded = true)String login,
            @Field(value = "email", encoded = true)String email,
            @Field(value = "pass", encoded = true)String pass
    );

}
