package co.allpro.allpro.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import co.allpro.allpro.data.AddingAllApiService
import co.allpro.allpro.data.CharacterPagingSource
import co.allpro.allpro.views.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddingAllRepository @Inject constructor(val api: AddingAllApiService) {

    companion object {
        const val MAX_ITEMS = 10
        const val PREFETCH_ITEMS = 3
    }

    fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = {
                CharacterPagingSource(api)
            }).flow
    }
}