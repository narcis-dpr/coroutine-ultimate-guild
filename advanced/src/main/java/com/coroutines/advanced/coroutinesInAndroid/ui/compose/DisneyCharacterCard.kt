package com.coroutines.advanced.coroutinesInAndroid.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.coroutines.advanced.coroutinesInAndroid.ui.theme.DisneyExplorerTheme

@Composable
fun DisneyCharacterCard(
  image: String = "",
  name: String = "",
  onClick: () -> Unit = {}
) {
  Surface(
    shape = RoundedCornerShape(16.dp),
    elevation = 8.dp,
    modifier = Modifier
      .fillMaxWidth()
      .padding(4.dp)
  ) {
    Row(
      Modifier
        .padding(12.dp)
        .fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      val painter = rememberImagePainter(data = image)
      Image(
        painter = painter,
        stringResource(R.string.cd_character_image),
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .size(64.dp)
          .clip(CircleShape)
      )
      Spacer(modifier = Modifier.size(20.dp))
      Text(text = name, modifier = Modifier.weight(2f))
      Text(text = "Details",
        modifier = Modifier
          .clickable { onClick() }
          .padding(8.dp)
          .weight(1f))
    }
  }
}

@Preview
@Composable
fun DefaultPreview() {
  DisneyExplorerTheme {
    DisneyCharacterCard(name = "Mickey")
  }
}
