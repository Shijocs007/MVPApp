package com.example.mvpapp.ui

import com.example.mvpapp.http.PropertyApi
import com.example.mvpapp.http.responsemodels.PropertyResponse
import com.example.mvpapp.models.Property
import io.reactivex.Observable

class HomeRepo(val api : PropertyApi) : HomeMVP.Model {
    override fun loadDataFromDB(): List<Property> {
        return emptyList()
    }

    override fun result(): Observable<PropertyResponse?> = api.getProperties()

}