package com.example.coinstatswidjettesttask.data.remote

import com.example.coinstatswidjettesttask.data.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
        @GET("bitcoin?")
        fun getForecast(@Query("currency") currency :String): Call<Response>
    }
