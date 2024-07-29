package co.allpro.allpro.viewModel.character

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import co.allpro.allpro.data.repository.AddingAllRepository
import co.allpro.allpro.views.model.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(repository: AddingAllRepository): ViewModel() {
    val characters : Flow<PagingData<CharacterModel>> = repository.getAllCharacters()

}