package com.coroutines.basics

import com.coroutines.basics.api.executeBackground
import com.coroutines.basics.api.executeMain
import com.coroutines.basics.api.getValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

fun main() {
    getUserFromNetworkCallback("202") { user, error ->
        user?.run(::println)
        error?.printStackTrace()
    }
    println("main end")
    /**
     * suspending
     */
    executeBackground {
        val user = getUserStandard("101")
        executeMain { println(user) }
    }
    Thread.sleep(1500)

    executeBackground {
        val user = getValue { getUserStandard("101") }

        executeMain { println(user) }
    }
    /**\
     * with context
     */

    GlobalScope.launch(Dispatchers.Main) {
        val user = getUserSuspended("101")
        println(user)
    }
}

private fun getUserStandard(userId: String): SuspendUser {
    Thread.sleep(1000)
    return SuspendUser(userId, "Filip")
}

private fun getUserFromNetworkCallback(
    userId: String,
    onUserResponse: (SuspendUser?, Throwable?) -> Unit,
) {
    thread {
        try {
            Thread.sleep(1000)

            val user = SuspendUser(userId, "Filip")
            onUserResponse(user, null)
        } catch (error: Throwable) {
            onUserResponse(null, error)
        }
    }
    println("end")
}

private suspend fun getUserSuspended(userId: String): SuspendUser = withContext(Dispatchers.Default) {
    delay(1000)
    SuspendUser(userId, "Filip")
}

internal data class SuspendUser(
    val id: String,
    val name: String,
)
