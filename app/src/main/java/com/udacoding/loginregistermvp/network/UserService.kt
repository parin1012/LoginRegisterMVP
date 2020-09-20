package com.udacoding.loginregistermvp.network

import com.udacoding.loginregistermvp.UI.login.model.ResponseLogin
import com.udacoding.loginregistermvp.UI.register.model.ResponseRegister
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {
    @FormUrlEncoded
    @POST("register.php")
    fun register(
        @Field("nama") nama : String,
        @Field("nohp") nohp : String,
        @Field("email") email : String,
        @Field("password") password : String,
    ) : Single<ResponseRegister>

    @FormUrlEncoded
    @POST("login.php")
    fun login(

        @Field("email") email : String,
        @Field("password") password : String,
    ) : Flowable<ResponseLogin>
}