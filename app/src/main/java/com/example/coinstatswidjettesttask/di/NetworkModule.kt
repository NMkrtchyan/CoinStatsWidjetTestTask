package com.example.coinstatswidjettesttask.di

import com.example.coinstatswidjettesttask.data.remote.Api
import com.example.coinstatswidjettesttask.ui.BASE_URL
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { OkHttpClient() }
    factory { provideCoinApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideCoinApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)