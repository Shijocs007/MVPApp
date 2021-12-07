package com.example.mvpapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    private val realmVersion = 1L
    @Provides
    fun providesRealmConfig(): RealmConfiguration =
        // 2.
        RealmConfiguration.Builder()
            .schemaVersion(realmVersion)
            .build()

    @Provides
    fun provideRealm(configuration : RealmConfiguration) : Realm = Realm.getInstance(configuration)
}