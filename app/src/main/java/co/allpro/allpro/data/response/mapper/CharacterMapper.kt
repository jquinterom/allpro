package co.allpro.allpro.data.response.mapper

import co.allpro.allpro.data.response.CharacterResponse
import co.allpro.allpro.views.model.CharacterModel

class CharacterMapper {
    fun toCharacterModel(characterResponse: CharacterResponse): CharacterModel {
        return CharacterModel(
            id = characterResponse.id,
            name = characterResponse.name,
            isAlive = characterResponse.status == "Alive",
            image = characterResponse.image,
            species = characterResponse.species,
            gender = characterResponse.gender,
            origin = characterResponse.origin,
            location = characterResponse.location
        )
    }
}