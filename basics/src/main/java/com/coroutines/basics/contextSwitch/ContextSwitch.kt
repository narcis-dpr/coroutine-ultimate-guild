package com.coroutines.basics.contextSwitch

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

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
        // which dispatcher is Unconfined running on?
        println(Thread.currentThread().name)
    }
    Thread.sleep(50)

    // creating a new work-stealing executor for executing a sample task :

    val executorDispatcher = Executors.newWorkStealingPool().asCoroutineDispatcher()

    GlobalScope.launch(context = executorDispatcher) {
        println(Thread.currentThread().name)
    }

    Thread.sleep(50)
}
