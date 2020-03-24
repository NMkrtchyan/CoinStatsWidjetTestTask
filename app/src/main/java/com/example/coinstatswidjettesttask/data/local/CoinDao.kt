package com.example.coinstatswidjettesttask.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coinstatswidjettesttask.data.model.Coin

@Dao
interface CoinDao {
    @Query("SELECT * FROM coin")
    suspend fun getCoin(): Coin?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(coin: Coin)

}
