package com.coroutines.advanced.coroutinesInAndroid.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coroutines.advanced.R
import com.coroutines.advanced.databinding.ActivityIntroBinding
import com.coroutines.advanced.coroutinesInAndroid.ui.compose.DisneyComposeActivity

class IntroActivity : AppCompatActivity() {
  private lateinit var binding: ActivityIntroBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // Set theme explicitly because we used another theme for the splash screen
    setTheme(R.style.AppTheme)
    binding = ActivityIntroBinding.inflate(layoutInflater)
    setContentView(binding.root)
    setClickListeners()
  }

  private fun setClickListeners() = with(binding) {
    chapter14.setOnClickListener { BackgroundProcessingActivity.start(this@IntroActivity) }
    chapter15.setOnClickListener { UiLayerActivity.start(this@IntroActivity) }
    chapter16.setOnClickListener { DisneyActivity.start(this@IntroActivity) }
    compose.setOnClickListener { DisneyComposeActivity.start(this@IntroActivity) }
  }
}
