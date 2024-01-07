package com.coroutines.basics.coroutineContext

import kotlin.coroutines.CoroutineContext

class CoroutineContextProviderImpl(
    private val context: CoroutineContext,
) : CoroutineContextProvider {
    override fun context(): CoroutineContext {
        return context
    }
}
