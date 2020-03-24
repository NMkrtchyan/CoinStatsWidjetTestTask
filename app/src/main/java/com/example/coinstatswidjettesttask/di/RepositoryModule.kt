package com.example.coinstatswidjettesttask.di

import com.example.coinstatswidjettesttask.data.local.AppDatabase
import com.example.coinstatswidjettesttask.data.local.Database
import com.example.coinstatswidjettesttask.data.repository.CoinRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val repositoryModule = module {
    factory { CoinRepository(get(),get())}
    single { get<AppDatabase>().coinDao() }
    single { Database().getAppDatabase(androidApplication()) }
}