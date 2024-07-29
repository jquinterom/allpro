package co.allpro.allpro.data.response

import co.allpro.allpro.views.model.CharacterLocation
import co.allpro.allpro.views.model.CharacterOrigin
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("image") val image: String,
    @SerializedName("species") val species: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: CharacterOrigin,
    @SerializedName("location") val location: CharacterLocation,
)