package com.example.mvpapp.ui

import com.example.mvpapp.http.PropertyApi
import com.example.mvpapp.http.responsemodels.PropertyResponse
import io.reactivex.Observable

class HomeRepo(val api : PropertyApi) : HomeMVP.Model {

    override fun result(): Observable<PropertyResponse?> = api.getProperties()

}