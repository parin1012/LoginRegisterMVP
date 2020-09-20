package com.udacoding.loginregistermvp.UI.login.presenter

import com.udacoding.loginregistermvp.UI.login.model.DataItem

interface LoginView {
    fun loginSucces(msg: String, user: List<DataItem?>)
    fun erorLogin(msg: String)
}