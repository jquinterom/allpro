package co.allpro.allpro.views.screens.character.characterCard.characterImage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.allpro.allpro.R
import co.allpro.allpro.views.model.CharacterModel
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.disk.DiskCache
import coil.memory.MemoryCache

@Composable
fun CharacterImage(characterModel: CharacterModel) {
    val context = LocalContext.current

    val imageLoader = ImageLoader.Builder(context)
        .memoryCache {
            MemoryCache.Builder(context)
                .maxSizePercent(0.25)
                .build()
        }
        .diskCache {
            DiskCache.Builder()
                .directory(context.cacheDir.resolve("image_cache"))
                .maxSizePercent(0.02)
                .build()
        }
        .build()

    Box(
        modifier = Modifier
            .height(200.dp)
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .testTag("rowImageTag")
            .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
        contentAlignment = Alignment.BottomCenter,
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = characterModel.image,
            contentDescription = "characterAvatar",
            imageLoader = imageLoader,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.loading_image),
        )

        ImageFooter(characterModel)

        CharacterStatus(characterModel.isAlive)
    }
}