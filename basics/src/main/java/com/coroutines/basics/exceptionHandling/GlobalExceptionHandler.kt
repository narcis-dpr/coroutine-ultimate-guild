package com.coroutines.basics.exceptionHandling

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    runBlocking {
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, exception ->
            println("Caught $exception")
        }

        val job = GlobalScope.launch(exceptionHandler) {
            throw AssertionError("My Custom Assertion Error!")
        }

        val deferred = GlobalScope.async(exceptionHandler) {
            throw ArithmeticException()
        }

        joinAll(job, deferred)
    }
}
