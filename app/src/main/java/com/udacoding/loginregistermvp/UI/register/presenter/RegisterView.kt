package com.udacoding.loginregistermvp.UI.register.presenter

import com.udacoding.loginregistermvp.UI.register.model.ResponseRegister

interface RegisterView {
    fun succesRegister(response : ResponseRegister)
    fun erorRegister(msg : String)
    fun empty()
    fun notMatch()
    fun startProgressBar()
    fun hideProgressBar()
}