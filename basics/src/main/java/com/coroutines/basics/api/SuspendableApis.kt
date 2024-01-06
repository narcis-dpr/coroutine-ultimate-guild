package com.coroutines.basics.api

import kotlin.coroutines.suspendCoroutine

suspend fun <T : Any> getValue(provider: () -> T): T =
    suspendCoroutine { continuation ->
        continuation.resumeWith(Result.runCatching { provider() })
    }