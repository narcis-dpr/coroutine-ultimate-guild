package com.coroutines.basics.coroutineContext

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun main() {
    val defaultDispatcher = Dispatchers.Default // 1- first element of coroutine context

    val coroutineErrorHandler = CoroutineExceptionHandler { context, error ->
        println("Problem with coroutine: $error")
    } // 2- second element of coroutine context

    val emptyParentJob = Job() // 3- third element of coroutine context

    val combinedContext = defaultDispatcher + coroutineErrorHandler + emptyParentJob

    GlobalScope.launch(context = combinedContext) {
        println(Thread.currentThread().name)
    }

    Thread.sleep(50)
    // context provider

    val parentJob = Job()
    val provider: CoroutineContextProvider =
        CoroutineContextProviderImpl(context = parentJob + Dispatchers.IO)

    GlobalScope.launch(context = provider.context()) {
        println(Thread.currentThread().name)
    }

    Thread.sleep(50)
}
