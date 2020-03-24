package com.example.coinstatswidjettesttask.domain

import android.content.Context
import androidx.work.*
import com.example.coinstatswidjettesttask.ui.service.SYNC_DATA_WORK_NAME
import com.example.coinstatswidjettesttask.ui.service.TAG_SYNC_DATA
import com.example.coinstatswidjettesttask.ui.service.WidgetWorker
import java.util.concurrent.TimeUnit


class WorkerUseCase(private val context: Context) {

    fun startPeriodicStepsPersistWork() {
        val timerWorkRequest = PeriodicWorkRequest.Builder(
            WidgetWorker::class.java,
            15,
            TimeUnit.MINUTES)

            .addTag(TAG_SYNC_DATA)
            .build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            SYNC_DATA_WORK_NAME
            , ExistingPeriodicWorkPolicy.KEEP
            , timerWorkRequest
        )
    }

}