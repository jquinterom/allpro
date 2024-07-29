package co.allpro.allpro.data

import co.allpro.allpro.data.response.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface AddingAllApiService {
    @GET("/api/character")
    suspend fun getCharacters(@Query("page") page: Int): ResponseWrapper
}