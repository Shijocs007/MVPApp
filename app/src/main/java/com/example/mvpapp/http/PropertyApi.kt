package com.example.mvpapp.http

import com.example.mvpapp.http.responsemodels.PropertyResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PropertyApi {

    @GET("iranjith4/ad-assignment/db")
    fun getProperties(): Observable<PropertyResponse?>
}