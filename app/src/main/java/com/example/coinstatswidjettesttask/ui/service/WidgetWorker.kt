package com.example.coinstatswidjettesttask.ui.service

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.coinstatswidjettesttask.data.repository.CoinRepository
import com.example.coinstatswidjettesttask.ui.CURRENCY_AMD
import com.example.coinstatswidjettesttask.ui.widget.BitcoinCurrencyWidget
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject


const val TAG_SYNC_DATA = "TAG_SYNC_DATA"
const val SYNC_DATA_WORK_NAME = "SYNC_DATA_WORK_NAME"

class WidgetWorker(private val context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams), KoinComponent {

    private val repository: CoinRepository by inject()

    override fun doWork(): Result {

        val response = repository.getBitCoinCurrency(CURRENCY_AMD).execute()
        return if (response.isSuccessful) {
            GlobalScope.launch {
                val operation = async(Dispatchers.IO) {
                    repository.insert(response.body()?.coin!!)
                }
                operation.await()
                BitcoinCurrencyWidget.forceWidgetUpdate(context)
            }
            Result.success()
        } else {
            Result.retry()
        }
    }


}

