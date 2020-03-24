package com.example.coinstatswidjettesttask.di

import com.example.coinstatswidjettesttask.domain.WorkerUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { WorkerUseCase(get()) }
}