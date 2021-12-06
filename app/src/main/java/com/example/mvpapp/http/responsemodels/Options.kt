package com.example.mvpapp.http.responsemodels

import com.google.gson.annotations.SerializedName

data class Options (

	@SerializedName("name") val name : String,
	@SerializedName("icon") val icon : String,
	@SerializedName("id") val id : Int
)