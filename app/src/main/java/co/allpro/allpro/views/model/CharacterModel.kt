package co.allpro.allpro.views.model

data class CharacterOrigin(
    val name: String
)

data class CharacterLocation(
    val name: String
)

data class CharacterModel(
    val id: Int,
    val name: String,
    val isAlive: Boolean,
    val image: String,
    val species: String,
    val gender: String,
    val origin : CharacterOrigin,
    val location: CharacterLocation
)