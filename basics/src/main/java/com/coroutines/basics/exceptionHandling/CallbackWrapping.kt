package com.coroutines.basics.exceptionHandling

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.IOException

fun main() {
    runBlocking {
        try {
            val data = getDataAsync()
            println("Data received $data")
        } catch (e: Exception) {
            println("Caught ${e.javaClass.simpleName}")
        }
    }
}

suspend fun getDataAsync(): String { // callback wrapping using coroutine
    return suspendCancellableCoroutine { continuation ->
        getData(object : AsyncCallback {
            override fun onSuccess(result: String) {
                continuation.resumeWith(Result.success(result))
            }

            override fun onError(e: Exception) {
                continuation.resumeWith(Result.failure(e))
            }
        })
    }
}

fun getData(asyncCallback: AsyncCallback) {
    // Flag used to trigger an exception
    val triggerError = false

    try {
        // Delaying the thread for 3 seconds
        Thread.sleep(3000)

        if (triggerError) {
            throw IOException()
        } else {
            // Send success
            asyncCallback.onSuccess("[Beep.Boop.Beep]")
        }
    } catch (e: Exception) {
        // send error
        asyncCallback.onError(e)
    }
}

// Callback
interface AsyncCallback {
    fun onSuccess(result: String)
    fun onError(e: Exception)
}
