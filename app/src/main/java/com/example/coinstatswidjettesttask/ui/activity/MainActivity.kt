package com.example.coinstatswidjettesttask.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.RemoteViews
import com.example.coinstatswidjettesttask.R
import com.example.coinstatswidjettesttask.data.model.Response
import com.example.coinstatswidjettesttask.data.repository.CoinRepository
import com.example.coinstatswidjettesttask.ui.CURRENCY_AMD
import org.koin.android.ext.android.inject
import retrofit2.Call
import java.lang.String

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
