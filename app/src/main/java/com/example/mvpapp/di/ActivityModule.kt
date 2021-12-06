package com.example.mvpapp.di

import com.example.mvpapp.http.PropertyApi
import com.example.mvpapp.ui.HomeMVP
import com.example.mvpapp.ui.HomePresenter
import com.example.mvpapp.ui.HomeRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    @Provides
    fun provideHomePresenter(model: HomeMVP.Model): HomeMVP.Presenter {
        return HomePresenter(model)
    }


    @Provides
    fun provideRepository(newsApiService: PropertyApi): HomeMVP.Model{
        return HomeRepo(newsApiService)
    }
}