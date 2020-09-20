package com.udacoding.loginregistermvp.UI.login.presenter

import com.udacoding.loginregistermvp.UI.login.model.ResponseLogin
import com.udacoding.loginregistermvp.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val login: LoginView) {

    fun login(email : String, password : String){

        if(email.isNotEmpty() && password.isNotEmpty()) {

            ConfigNetwork.getNetwork().login(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    respon ->
                    respon.data?.let { login.loginSucces("", it) }
                },{
                    login.erorLogin(it.localizedMessage)
                })


            /*
            ConfigNetwork.getNetwork().login(email, password)
                .enqueue(object : Callback<ResponseLogin> {
                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        if (response.isSuccessful) {
                            val status = response.body()?.isSucces
                            val message = response.body()?.message
                            if (status ?: true) {
                                message?.let {
                                    response.body()!!.data?.let { it1 ->
                                        login.loginSucces(
                                            it,
                                            it1
                                        )
                                    }
                                }
                            } else {
                                login.erorLogin(message ?: "")
                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        login.erorLogin(t.localizedMessage)
                    }
                })
                
             */


        }else{
            login.erorLogin("Tidak boleh ada yang kosong")
        }

    }
}