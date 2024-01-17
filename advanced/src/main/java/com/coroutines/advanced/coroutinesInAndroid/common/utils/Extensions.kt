package com.raywenderlich.android.disneyexplorer.common.utils

import android.content.Context
import android.widget.Button
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun Context.showToast(text: String) {
  Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}
