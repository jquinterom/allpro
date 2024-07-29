package co.allpro.allpro.views.screens.character.characterCard.characterImage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CharacterStatus(isAlive: Boolean) {
    val color: Color = if (isAlive) Color.Green else Color.Red

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 8.dp, top = 8.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Box(
            modifier = Modifier
                .height(10.dp)
                .width(10.dp)
                .clip(CircleShape)
                .background(color)
        )
    }
}