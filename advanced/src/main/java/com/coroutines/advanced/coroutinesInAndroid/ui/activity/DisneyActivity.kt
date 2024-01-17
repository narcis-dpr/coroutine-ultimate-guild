package com.coroutines.advanced.coroutinesInAndroid.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coroutines.advanced.R
import com.coroutines.advanced.databinding.ActivityNetworkingBinding
import com.raywenderlich.android.disneyexplorer.data.model.DisneyCharacter
import com.raywenderlich.android.disneyexplorer.di.DependencyHolder
import com.coroutines.advanced.coroutinesInAndroid.ui.adapter.list.DisneyAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DisneyActivity : AppCompatActivity() {
  private lateinit var binding: ActivityNetworkingBinding
  private val apiService by lazy { DependencyHolder.apiService }
  private val adapter by lazy { DisneyAdapter() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityNetworkingBinding.inflate(layoutInflater)
    setContentView(binding.root)
    initUi()
    binding.startProcessing.setOnClickListener { fetchDisneyCharacters() }
  }

  private fun initUi() {
    startLoadingAnimation()
    binding.characterList.adapter = adapter
    binding.characterList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
  }

  private fun startLoadingAnimation() {
    val animation = AnimationUtils.loadAnimation(this, R.anim.rotate_indefinitely)
    binding.loadingAnimation.startAnimation(animation)
  }

  private fun showResults(characters: List<DisneyCharacter>) = with(binding) {
    characterList.visibility = View.VISIBLE
    uiProcessingContainer.visibility = View.GONE
    adapter.setData(characters)
  }

  private fun fetchDisneyCharacters() {
    // Create a new coroutine in the scope tied to the lifecycle of the Activity
    lifecycleScope.launch(Dispatchers.IO) {
      // Make the network request on a background thread
      runCatching { apiService.getDisneyCharacters() }
        .onSuccess {
          // Switch to the main thread to show the results
          withContext(Dispatchers.Main) {
            showResults(it)
          }
        }
        .onFailure { it.printStackTrace() }
    }
  }

  companion object {
    fun start(from: Context) =
      from.startActivity(Intent(from, DisneyActivity::class.java))
  }
}
