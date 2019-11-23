package com.example.decocioapp.Network;

import com.example.decocioapp.Model.ResponseLogin;
import com.example.decocioapp.Model.ResponseRegister;

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
            @Field(value = "password", encoded = true)String password
    );

//    @FormUrlEncoded
//    @POST("exec")
//    Call<ResponseRegister> registerUser(
//            @Field(value = "sheetName", encoded = true)String SheetName,
//            @Field(value = "action", encoded = true)String insert,
//            @Field(value = "username", encoded = true)String username,
//            @Field(value = "password", encoded = true)String password,
//            @Field(value = "email", encoded = true)String email,
//            @Field(value = "sebagai", encoded = true)String sebagai
//    );

}
