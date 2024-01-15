package com.coroutines.advanced.coroutineTest.contextProvider

import kotlin.coroutines.CoroutineContext

class CoroutineContextProviderImpl(private val context: CoroutineContext) : CoroutineContextProvider {

    override fun context(): CoroutineContext = context
}
