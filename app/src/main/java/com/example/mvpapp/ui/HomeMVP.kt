package com.example.mvpapp.ui

import com.example.mvpapp.http.responsemodels.Exclusions
import com.example.mvpapp.http.responsemodels.Facilities
import com.example.mvpapp.http.responsemodels.PropertyResponse
import io.reactivex.Observable

interface HomeMVP {

    interface View {
        fun setFacilities(facilities: List<Facilities>)
        fun setExclusions(exclusions: List<List<Exclusions>>)
        fun showProgressDialog()
        fun dismissProgressDialog()
    }

    interface Presenter {
        fun loadData()
        fun rxUnsubscribe()
        fun makeView(view: View)
    }

    interface Model {
        fun result(): Observable<PropertyResponse?>
    }
}