package co.allpro.allpro.views.screens.character.characterCard.characterImage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.allpro.allpro.views.model.CharacterModel

@Composable
fun ImageFooter(characterModel: CharacterModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0f),
                        MaterialTheme.colorScheme.primary.copy(alpha = .6f),
                        MaterialTheme.colorScheme.primary.copy(alpha = 1f),
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = characterModel.name,
            modifier = Modifier,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary
            )
        )
    }
}