package com.example.coinstatswidjettesttask.ui

import android.app.Application
import com.example.coinstatswidjettesttask.di.domainModule
import com.example.coinstatswidjettesttask.di.networkModule
import com.example.coinstatswidjettesttask.di.repositoryModule
import com.example.coinstatswidjettesttask.domain.WorkerUseCase
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class BaseApplication: Application() {

    val workerUseCase: WorkerUseCase by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin()
        workerUseCase.startPeriodicStepsPersistWork()
    }

    fun startKoin() {
        val koinModuls = listOf(
            networkModule,
            repositoryModule,
            domainModule
        )

        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(koinModuls)
        }
    }
}