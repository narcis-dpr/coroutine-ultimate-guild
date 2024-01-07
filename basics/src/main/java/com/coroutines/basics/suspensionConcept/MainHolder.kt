package com.coroutines.basics.suspensionConcept

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    mainDispatcherFun()
}

fun coroutineBuilder() {
    (1..10000).forEach {
        GlobalScope.launch {
            val threadName = Thread.currentThread().name
            println("$it printed on thread $threadName")
        }
        Thread.sleep(1000)
    }
}

fun delayFun() {
    GlobalScope.launch {
        println("Hello coroutine!")
        delay(500)
        println("Right back at ya!")
    }
    Thread.sleep(1000)
}

fun jobFun() {
    val job1 = GlobalScope.launch(start = CoroutineStart.LAZY) {
        delay(200)
        println("Pong")
        delay(200)
    }
    GlobalScope.launch {
        delay(200)
        println("Ping")
        job1.join()
        println("Ping")
        delay(200)
    }
    Thread.sleep(1000)
}

fun jobHierarchy() {
    with(GlobalScope) {
        val parentJon = launch {
            delay(200)
            println("Im the parent")
            delay(200)
        }
        launch(context = parentJon) {
            delay(200)
            println("Im a child")
            delay(200)
        }

        if (parentJon.children.iterator().hasNext()) {
            println("The job has children!")
        } else {
            println("th job has no children")
        }
        Thread.sleep(1000)
    }
}

fun standardFunWithCoroutine() {
    var isDoorOpen = false
    println("Unlocking the door ... please wait.\n")
    GlobalScope.launch {
        delay(3000)

        isDoorOpen = true
    }

    GlobalScope.launch {
        repeat(4) {
            println("Trying to open the door... \n")
            delay(800)

            if (isDoorOpen) {
                println("Opened the door! \n")
            } else {
                println("The door is still locked \n")
            }
        }
    }
    Thread.sleep(5000)
}
fun mainDispatcherFun() {
    GlobalScope.launch {
        val bigThreadName = Thread.currentThread().name
        println("Im Job 1 thread $bigThreadName")
        delay(200)
        GlobalScope.launch(Dispatchers.Main) {
            val uiThreadName = Thread.currentThread().name
            println("Im Job 2 in thread $uiThreadName")
        }
    }
    Thread.sleep(1000)
}
