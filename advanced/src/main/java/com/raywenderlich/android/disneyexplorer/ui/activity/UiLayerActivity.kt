package com.raywenderlich.android.disneyexplorer.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coroutines.advanced.databinding.ActivityUiLayerBinding
import com.coroutines.advanced.coroutinesInAndroid.ui.adapter.NumbersAdapter

class UiLayerActivity : AppCompatActivity() {
  private lateinit var binding: ActivityUiLayerBinding
  private val adapter by lazy { NumbersAdapter() }
  // Declare flowCollectorJob here

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityUiLayerBinding.inflate(layoutInflater)
    setContentView(binding.root)
    setupList()
    runProcessingWithFlow()
  }

  private fun setupList() = with(binding) {
    numbers.layoutManager = LinearLayoutManager(this@UiLayerActivity, RecyclerView.VERTICAL, false)
    numbers.setHasFixedSize(true)
    numbers.adapter = adapter
  }

  private fun runProcessingWithFlow() {
    // Add the implementation here
  }

  override fun onStart() {
    super.onStart()
    println("FLOW: DisneyActivity.onStart")
  }

  override fun onStop() {
    // Cancel flowCollectorJob here
    super.onStop()
    println("FLOW: DisneyActivity.onStop")
  }

  companion object {
    fun start(from: Context) =
      from.startActivity(Intent(from, UiLayerActivity::class.java))
  }
}
