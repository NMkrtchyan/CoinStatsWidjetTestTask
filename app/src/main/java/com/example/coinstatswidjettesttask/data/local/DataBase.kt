package com.example.coinstatswidjettesttask.data.local

import android.content.Context
import androidx.room.Room

const val APP_DATABASE = "app_database"

class Database {

    fun getAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, APP_DATABASE)
            .build()
}