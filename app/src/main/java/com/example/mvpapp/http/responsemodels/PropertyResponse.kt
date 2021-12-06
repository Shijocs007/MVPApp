package com.example.mvpapp.http.responsemodels

import com.google.gson.annotations.SerializedName

data class PropertyResponse (

	@SerializedName("facilities") val facilities : List<Facilities>,
	@SerializedName("exclusions") val exclusions : List<List<Exclusions>>
)