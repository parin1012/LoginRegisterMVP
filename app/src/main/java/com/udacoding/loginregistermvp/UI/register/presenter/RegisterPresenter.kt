package com.udacoding.loginregistermvp.UI.register.presenter

import com.udacoding.loginregistermvp.network.ConfigNetwork
import com.udacoding.loginregistermvp.UI.register.model.ResponseRegister
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val registerView: RegisterView) {

    fun register(nama : String, email : String, hp : String, password : String, passwordConfirm : String){
        registerView.startProgressBar()
        

        if(nama.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && hp.isNotEmpty()) {
            registerView.hideProgressBar()
            if(password != passwordConfirm) {
                registerView.notMatch()
                registerView.hideProgressBar()
            }else if(password.length < 6){
                registerView.erorRegister("Password minimal 6 karakter")
                registerView.hideProgressBar()
            }else {
                registerView.hideProgressBar()
                ConfigNetwork.getNetwork().register(nama,hp, email, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        registerView.succesRegister(it)
                    },{
                        registerView.erorRegister(it.localizedMessage)
                    })

                /*
                ConfigNetwork.getNetwork().register(nama, email, hp, password)
                    .enqueue(object : Callback<ResponseRegister> {
                        override fun onResponse(
                            call: Call<ResponseRegister>,
                            response: Response<ResponseRegister>
                        ) {
                            if (response.isSuccessful) {
                                registerView.hideProgressBar()
                                val responseServer = response.body()
                                val message = response.body()?.message
                                val status = response.body()?.isSucces
                                if (status ?: true) {
                                    responseServer?.let { registerView.succesRegister(it) }
                                } else {
                                    registerView.erorRegister(message ?: "")
                                }

                            }
                        }

                        override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                            registerView.erorRegister(t.localizedMessage)
                            registerView.hideProgressBar()
                        }
                    })

                 */
            }
        }else{
            registerView.hideProgressBar()
            registerView.empty()
        }


    }
}