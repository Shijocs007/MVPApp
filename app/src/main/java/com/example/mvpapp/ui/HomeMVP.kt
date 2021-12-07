package com.example.mvpapp.ui

import com.example.mvpapp.http.responsemodels.Exclusions
import com.example.mvpapp.http.responsemodels.Facilities
import com.example.mvpapp.http.responsemodels.PropertyResponse
import com.example.mvpapp.models.Property
import io.reactivex.Observable

interface HomeMVP {

    interface View {
        fun setFacilities(facilities: List<Property>)
        fun setExclusions(exclusions: List<List<Exclusions>>)
        fun showProgressDialog()
        fun dismissProgressDialog()
    }

    interface Presenter {
        fun loadDataFromDB()
        fun loadData()
        fun rxUnsubscribe()
        fun makeView(view: View)
    }

    interface Model {
        fun insertAllDb(properties : List<Property>)
        fun loadDataFromDB() : List<Property>
        fun result(): Observable<PropertyResponse?>
    }
}