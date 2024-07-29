package co.allpro.allpro.views.screens.character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import co.allpro.allpro.common.views.AddingAllLoading
import co.allpro.allpro.viewModel.character.CharacterListViewModel
import co.allpro.allpro.views.screens.character.characterCard.CharacterCard

@Composable
fun CharacterListScreen(modifier: Modifier, listViewModel: CharacterListViewModel = hiltViewModel()) {
    val characters = listViewModel.characters.collectAsLazyPagingItems()

    when {
        characters.loadState.refresh is LoadState.Loading && characters.itemCount == 0 -> {
            AddingAllLoading()
        }

        characters.loadState.refresh is LoadState.NotLoading && characters.itemCount == 0 -> {
            Text(text = "No characters were found")
        }

        characters.loadState.hasError -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondary),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "An error was occurred")
            }
        }

        else -> {
            LazyColumn(modifier = modifier.background(color = MaterialTheme.colorScheme.secondary)) {
                items(characters.itemCount) { characterModel ->
                    characters[characterModel]?.let {
                        CharacterCard(it)
                    }
                }
            }

            if (characters.loadState.append is LoadState.Loading) {
                AddingAllLoading()
            }
        }
    }
}
