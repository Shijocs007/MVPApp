package com.example.mvpapp.models

import io.realm.RealmObject
import io.realm.annotations.Required

open class Property( var id : Int = 0,
                     var name : String = "",
                     var type : Int = 1) :  RealmObject()
