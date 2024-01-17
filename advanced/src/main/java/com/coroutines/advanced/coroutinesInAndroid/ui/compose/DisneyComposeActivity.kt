package com.coroutines.advanced.coroutinesInAndroid.ui.compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import com.coroutines.advanced.coroutinesInAndroid.ui.viewmodel.DisneyViewModel
import com.raywenderlich.android.disneyexplorer.data.model.DisneyCharacter

class DisneyComposeActivity : ComponentActivity() {
//  private val viewModel: DisneyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//    setContent {
//      DisneyExplorerTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//          MainDisneyScreen(viewModel = viewModel, lifecycle = lifecycle)
//        }
//      }
//    }
    }

    companion object {
        fun start(from: Context) =
            from.startActivity(Intent(from, DisneyComposeActivity::class.java))
    }
}

@Composable
fun MainDisneyScreen(viewModel: DisneyViewModel, lifecycle: Lifecycle) {
    // remember the ui state until it changes
//  val uiStateFlow = remember(viewModel.uiState) {
    // Automatically starts/stops collecting based on the specified lifecycle
//    viewModel.uiState.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
//  }
    // Collects the flow as State (Compose State)
//  val charactersList by uiStateFlow.collectAsState(emptyList())
//  CharacterList(characterList = charactersList)
}

@Composable
private fun CharacterList(characterList: List<DisneyCharacter>) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(characterList) { character ->
            DisneyCharacterCard(
                image = character.imageUrl,
                name = character.name,
            )
        }
    }
}
