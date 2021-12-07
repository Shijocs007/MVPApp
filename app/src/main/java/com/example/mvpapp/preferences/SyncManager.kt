package com.example.mvpapp.preferences

import android.content.Context
import android.content.SharedPreferences
import android.provider.SyncStateContract
import com.example.mvpapp.utils.API_SYNC_TIME

object SyncManager {

    private var preferences : SharedPreferences ? = null

    fun init(context: Context) : SyncManager {
        if(preferences == null)
            preferences = context.getSharedPreferences("properties_prefercences", Context.MODE_PRIVATE)
        return this
    }

    fun updateApiFetchTime() {
        val editor = preferences?.edit()
        editor?.putLong(API_SYNC_TIME, System.currentTimeMillis())
        editor?.apply()
    }

    fun getLastSyncTime() : Long? {
        return preferences?.getLong(API_SYNC_TIME, 0)
    }
}