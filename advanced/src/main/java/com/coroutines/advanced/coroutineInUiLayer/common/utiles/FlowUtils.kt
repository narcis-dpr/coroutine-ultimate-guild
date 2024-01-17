package com.coroutines.advanced.coroutineInUiLayer.common.utiles

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.random.Random

object FlowUtils {

    fun testDataFlow() = flow {
        while (true) {
            emit(Random.nextInt())
            println("FLOW: Emitting item")
            kotlinx.coroutines.delay(500)
        }
    }.flowOn(Dispatchers.Default)
}
