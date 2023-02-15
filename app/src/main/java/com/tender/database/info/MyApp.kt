package com.tender.database.info

import android.app.Application
import com.tender.database.info.api.API
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MyApp: Application() {
    @Inject
    lateinit var retrofit: Retrofit
    companion object {
        lateinit var api: API
    }
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
        retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://tenders.guru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(API::class.java)
    }
}