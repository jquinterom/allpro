package co.allpro.allpro.views.screens.character.characterCard

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.allpro.allpro.ui.theme.AllProTheme
import co.allpro.allpro.views.model.CharacterLocation
import co.allpro.allpro.views.model.CharacterModel
import co.allpro.allpro.views.model.CharacterOrigin
import co.allpro.allpro.views.screens.character.characterCard.characterImage.CharacterImage

@Composable
fun CharacterCard(characterModel: CharacterModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 16.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        CharacterImage(characterModel)

        CardFooter(characterModel = characterModel)
    }
}

@Composable
fun CardFooter(characterModel: CharacterModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = "${characterModel.species}, ${characterModel.gender}",
            style = TextStyle(Color(0xffcfffff), fontSize = 14.sp)
        )

        Text(
            text = "${characterModel.origin.name} - ${characterModel.location.name}",
            style = TextStyle(Color(0xffcfffff), fontSize = 12.sp)
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview
@Composable
fun CharacterCardPreview() {
    AllProTheme {
        CharacterCard(
            CharacterModel(
                id = 1,
                name = "Name",
                isAlive = false,
                image = "",
                species = "Human",
                gender = "Male",
                origin = CharacterOrigin(name = "Earth"),
                location = CharacterLocation(name = "Earth - (Country)")
            )
        )
    }
}