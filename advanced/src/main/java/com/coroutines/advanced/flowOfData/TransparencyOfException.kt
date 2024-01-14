package com.coroutines.advanced.flowOfData

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    val flowOfString = flow {
//        emit("") : uncomment to see an exception
        for (number in 0..100) {
            emit("Emitting $number")
        }
    }
    GlobalScope.launch {
        flowOfString
            .map { it.split(" ") }
            .map { it[1] }
//            .catch { CoroutineExceptionHandler }
            .catch {
                it.printStackTrace()
                emit("Fallback")
            }
            .flowOn(Dispatchers.Default)
            .collect { println(it) }
    }
    println("the code still work")
}
