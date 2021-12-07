package com.example.mvpapp.di

import android.content.Context
import com.example.mvpapp.preferences.SyncManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PreferenceModule {

    @Provides
    fun provideSyncManager(@ApplicationContext appContext: Context) : SyncManager {
        return SyncManager.init(appContext)
    }
}