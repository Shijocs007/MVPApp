package com.example.mvpapp.di

import com.example.mvpapp.http.PropertyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    val BASE_URL = "https://my-json-server.typicode.com/"

    /**
     * provide OkHttpClient client
     */
    @Provides
    fun provideClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor { chain ->
            var request = chain.request()
            val url = request.url().newBuilder().build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }.build()
    }

    /**
     * provide Retrofit instance for the app
     * @param baseURL base url of the API
     * @param  client OKHttpClient needed for the app
     */
    @Provides
    fun provideRetrofit(baseURL: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * This method provide Retrofit interface of all network requests */
    @Provides
    fun provideApiService(): PropertyApi {
        return provideRetrofit(BASE_URL, provideClient()).create(PropertyApi::class.java)
    }

}