package com.coroutines.basics.contextSwitch

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch { // emptyCoroutineContext
        println("This is a coroutine")
    }
    Thread.sleep(50)

    GlobalScope.launch { // print the name of current thread aka DefaultDispatcher
        println(Thread.currentThread().name)
    }
    Thread.sleep(50)

    GlobalScope.launch(context = Dispatchers.Default) {
        // printing the same as previous one
        println(Thread.currentThread().name)
    }
    Thread.sleep(50)

    GlobalScope.launch(context = Dispatchers.Unconfined) {
        println(Thread.currentThread().name)
    }
    Thread.sleep(50)
}
