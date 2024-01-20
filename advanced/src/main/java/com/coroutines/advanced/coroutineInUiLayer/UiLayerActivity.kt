package com.coroutines.advanced.coroutineInUiLayer

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.coroutines.advanced.coroutineInUiLayer.ui.theme.CoroutineUltimateGuideTheme
import com.raywenderlich.android.disneyexplorer.common.utils.FlowUtils
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UiLayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutineUltimateGuideTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting2("Android")
                }
            }
        }
    }

    private fun runProcessingWithFlow() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                FlowUtils.testDataFlow().collect {
                    println("Flow: value is: $it")
                }
            }
        }
    }
    private fun runProcessingWithAFlow() {
        lifecycleScope.launch {
            FlowUtils.testDataFlow().flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    println("Flow: value is $it")
                }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    CoroutineUltimateGuideTheme {
        Greeting2("Android")
    }
}
