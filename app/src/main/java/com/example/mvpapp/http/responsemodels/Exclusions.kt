package com.example.mvpapp.http.responsemodels

import com.google.gson.annotations.SerializedName


data class Exclusions (

	@SerializedName("facility_id") val facility_id : Int,
	@SerializedName("options_id") val options_id : Int
)