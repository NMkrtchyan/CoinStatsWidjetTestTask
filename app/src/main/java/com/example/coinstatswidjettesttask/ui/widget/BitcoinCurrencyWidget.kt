package com.example.coinstatswidjettesttask.ui.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log.d
import android.widget.RemoteViews
import com.example.coinstatswidjettesttask.R
import com.example.coinstatswidjettesttask.data.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject


/**
 * Implementation of App Widget functionality.
 */


class BitcoinCurrencyWidget : AppWidgetProvider(), KoinComponent {

    val repository: CoinRepository by inject()

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(
                context,
                appWidgetManager,
                appWidgetId
            )
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    companion object {
        fun forceWidgetUpdate(context: Context) {
            forceWidgetUpdate(null, context)
        }

        fun forceWidgetUpdate(widgetId: Int?, context: Context) {
            val intent = Intent(context, BitcoinCurrencyWidget::class.java)
            intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
            val ids = widgetId?.let { intArrayOf(it) }
                ?: AppWidgetManager.getInstance(context).getAppWidgetIds(
                    ComponentName(
                        context,
                        BitcoinCurrencyWidget::class.java
                    )
                )
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids)
            context.sendBroadcast(intent)
        }
    }

    fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
        val widgetText = context.getString(R.string.appwidget_text)
        // Construct the RemoteViews object
        val views = RemoteViews(
            context.packageName,
            R.layout.bitcoin_currency_widget
        )

        GlobalScope.launch {
            val coin = repository.getCoin()
            views.setTextViewText(R.id.appwidget_text, coin?.name)
            views.setTextViewText(R.id.price_text, "Price - ${coin?.price.toString()}")
            views.setTextViewText(R.id.volume_text, "Volume - ${coin?.volume.toString()}")
            views.setTextViewText(R.id.market_text, "MarketCap - ${coin?.marketCap.toString()}")
            views.setTextViewText(R.id.price_changeH_text, "PriceChange1h - ${coin?.priceChange1h.toString()}")
            views.setTextViewText(R.id.price_changeD_text, "PriceChange1d - ${coin?.priceChange1d.toString()}")
            views.setTextViewText(R.id.price_changeW_text, "PriceChange1w - ${coin?.priceChange1w.toString()}")
            appWidgetManager.updateAppWidget(appWidgetId, views)
            d("count", "widget")
        }
    }
}
