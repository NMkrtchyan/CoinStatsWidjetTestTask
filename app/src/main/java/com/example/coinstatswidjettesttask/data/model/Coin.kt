package com.example.coinstatswidjettesttask.data.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "coin")
data class Coin(

	@field:SerializedName("symbol")
	val symbol: String? = null,

	@field:SerializedName("marketCap")
	val marketCap: Double? = null,

	@field:SerializedName("priceChange1w")
	val priceChange1w: Double? = null,

	@field:SerializedName("availableSupply")
	val availableSupply: Int? = null,

	@field:SerializedName("totalSupply")
	val totalSupply: Int? = null,

	@field:SerializedName("twitterUrl")
	val twitterUrl: String? = null,

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("priceChange1h")
	val priceChange1h: Double? = null,

	@field:SerializedName("priceBtc")
	val priceBtc: Int? = null,

	@field:SerializedName("volume")
	val volume: Double? = null,

	@field:SerializedName("priceChange1d")
	val priceChange1d: Double? = null,

	@field:SerializedName("websiteUrl")
	val websiteUrl: String? = null,

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("rank")
	val rank: Int? = null,

	@PrimaryKey
	@NonNull
	@field:SerializedName("id")
	val id: String
)