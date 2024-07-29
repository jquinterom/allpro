package co.allpro.allpro.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import co.allpro.allpro.data.response.mapper.CharacterMapper
import co.allpro.allpro.views.model.CharacterModel
import java.io.IOException
import javax.inject.Inject

class CharacterPagingSource @Inject constructor(private val api: AddingAllApiService) :
    PagingSource<Int, CharacterModel>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        return try {
            val page = params.key ?: 1
            val response = api.getCharacters(page)
            val characters = response.results

            val prevKey = if (page > 0) page - 1 else null
            val nextKey = if (response.information.next != null) page + 1 else null

            val newCharacters = characters.map { character ->
                CharacterMapper().toCharacterModel(character)
            }

            LoadResult.Page(newCharacters, prevKey, nextKey)

        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }

}