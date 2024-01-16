package com.coroutines.advanced.coroutinesInAndroid.utils

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import com.coroutines.advanced.coroutinesInAndroid.MainActivity

internal object BroadcasterUtil {

    /**
     * Send local broadcast with the bitmap as payload
     * @param context Context
     * @param bmp Bitmap
     * @return Unit
     */
    fun sendBitmap(context: Context, bmp: Bitmap?) {
        val newIntent = Intent()
        bmp?.let {
            newIntent.putExtra("bitmap", it)
            newIntent.action = MainActivity.FILTER_ACTION_KEY
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(context).sendBroadcast(newIntent)
        }
    }

    /**
     * Register Local Broadcast Manager with the receiver
     * @param context Context
     * @param myBroadcastReceiver MyBroadcastReceiver
     * @return Unit
     */
    fun registerReceiver(context: Context, myBroadcastReceiver: MyBroadcastReceiver?) {
        myBroadcastReceiver?.let {
            val intentFilter = IntentFilter()
            intentFilter.addAction(MainActivity.FILTER_ACTION_KEY)
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(context).registerReceiver(it, intentFilter)
        }
    }

    /**
     * Unregister Local Broadcast Manager from the receiver
     * @param context Context
     * @param myBroadcastReceiver MyBroadcastReceiver
     * @return Unit
     */
    fun unregisterReceiver(context: Context, myBroadcastReceiver: MyBroadcastReceiver?) {
        myBroadcastReceiver?.let {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(context).unregisterReceiver(it)
        }
    }
}
