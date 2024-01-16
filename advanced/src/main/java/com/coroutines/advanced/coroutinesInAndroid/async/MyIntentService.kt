package com.coroutines.advanced.coroutinesInAndroid.async

import android.app.IntentService
import android.content.Intent
import com.coroutines.advanced.coroutinesInAndroid.utils.BroadcasterUtil
import com.coroutines.advanced.coroutinesInAndroid.utils.DownloaderUtil

// Required constructor with a name for the service
class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        // Download Image
        val bmp = DownloaderUtil.downloadImage()

        // Send local broadcast with the bitmap as payload
        BroadcasterUtil.sendBitmap(applicationContext, bmp)
    }
}
