package com.example.mvpapp.di

import com.example.mvpapp.http.PropertyApi
import com.example.mvpapp.preferences.SyncManager
import com.example.mvpapp.ui.HomeMVP
import com.example.mvpapp.ui.HomePresenter
import com.example.mvpapp.ui.HomeRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import io.realm.Realm

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    @Provides
    fun provideHomePresenter(model: HomeMVP.Model, syncManager : SyncManager): HomeMVP.Presenter {
        return HomePresenter(model, syncManager)
    }


    @Provides
    fun provideRepository(newsApiService: PropertyApi, realm: Realm): HomeMVP.Model{
        return HomeRepo(newsApiService, realm)
    }
}