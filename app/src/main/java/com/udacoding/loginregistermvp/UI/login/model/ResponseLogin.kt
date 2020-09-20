package com.udacoding.loginregistermvp.UI.login.model

import com.google.gson.annotations.SerializedName

data class ResponseLogin(

	@field:SerializedName("isSucces")
	val isSucces: Boolean? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class DataItem(

	@field:SerializedName("user_nama")
	val userNama: String? = null,

	@field:SerializedName("user_password")
	val userPassword: String? = null,

	@field:SerializedName("user_email")
	val userEmail: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("user_hp")
	val userHp: String? = null
)
