package com.example.mvpapp.ui

import com.example.mvpapp.http.PropertyApi
import com.example.mvpapp.http.responsemodels.PropertyResponse
import com.example.mvpapp.models.Property
import io.reactivex.Observable
import io.realm.Realm
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeRepo(val api : PropertyApi, val realm: Realm) : HomeMVP.Model {

    override fun insertAllDb(properties: List<Property>) {
        GlobalScope.launch(Dispatchers.IO) {
            realm.executeTransaction { realm -> realm.insertOrUpdate(properties) }
        }
    }

    override fun loadDataFromDB(): List<Property> {
        return realm.where(Property::class.java).findAll()
    }

    override fun result(): Observable<PropertyResponse?> = api.getProperties()

}