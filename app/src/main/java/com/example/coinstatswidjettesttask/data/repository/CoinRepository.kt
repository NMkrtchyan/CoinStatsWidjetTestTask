package com.example.coinstatswidjettesttask.data.repository

import com.example.coinstatswidjettesttask.data.local.CoinDao
import com.example.coinstatswidjettesttask.data.model.Coin
import com.example.coinstatswidjettesttask.data.model.Response
import com.example.coinstatswidjettesttask.data.remote.Api
import retrofit2.Call

class CoinRepository(private val api: Api, private val dao: CoinDao) {

    fun getBitCoinCurrency(string: String): Call<Response> = api.getForecast(string)

    suspend fun getCoin() = dao.getCoin()
    suspend fun insert(coin: Coin) = dao.insert(coin)
}