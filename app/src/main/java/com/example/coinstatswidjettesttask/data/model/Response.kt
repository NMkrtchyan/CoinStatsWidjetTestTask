package com.example.coinstatswidjettesttask.data.model

import com.google.gson.annotations.SerializedName

data class Response(
	@field:SerializedName("coin")
	val coin: Coin? = null
)