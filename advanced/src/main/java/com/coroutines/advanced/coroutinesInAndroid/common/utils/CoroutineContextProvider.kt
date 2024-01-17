package com.raywenderlich.android.disneyexplorer.common.utils

import com.coroutines.advanced.coroutineInUiLayer.common.utiles.CoroutineContextProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

open class CoroutineContextProvider {
  open val mainDispatcher: CoroutineDispatcher = Dispatchers.Main
  open val ioDispatcher = Dispatchers.IO
  open val defaultDispatcher = Dispatchers.Default
}

class TestCoroutineContextProvider : CoroutineContextProvider() {
  override val mainDispatcher = Dispatchers.Unconfined
  override val ioDispatcher = Dispatchers.Unconfined
  override val defaultDispatcher = Dispatchers.Unconfined
}
