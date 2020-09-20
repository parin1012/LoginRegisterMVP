package com.udacoding.loginregistermvp.UI.register.model

import com.google.gson.annotations.SerializedName

data class ResponseRegister(

	@field:SerializedName("isSucces")
	val isSucces: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)
