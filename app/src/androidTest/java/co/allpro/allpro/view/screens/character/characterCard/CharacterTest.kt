package co.allpro.allpro.view.screens.character.characterCard

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.allpro.allpro.views.model.CharacterLocation
import co.allpro.allpro.views.model.CharacterModel
import co.allpro.allpro.views.model.CharacterOrigin
import co.allpro.allpro.views.screens.character.characterCard.CharacterCard
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CharacterTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setupCharacterCardToContent() {
        val characterModel = CharacterModel(
            id = 1,
            name = "Beta-Seven",
            isAlive = false,
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            species = "Human",
            gender = "Male",
            origin = CharacterOrigin(name = "Earth (C-137)"),
            location = CharacterLocation(name = "Citadel of Ricks")
        )
        composeTestRule.setContent {
            CharacterCard(characterModel)
        }
    }

    @Test
    fun testFillMaxWidthOfRowImage() {
        val rowTag = "rowImageTag"
        composeTestRule.onNodeWithTag(rowTag).assertExists()

        composeTestRule.onNodeWithContentDescription("characterAvatar").assertIsDisplayed()
    }

    @Test
    fun testAllDetailsAreDisplayed() {
        composeTestRule.onNodeWithText("Beta-Seven").assertIsDisplayed()
        composeTestRule.onNodeWithText("Human, Male").assertIsDisplayed()
        composeTestRule.onNodeWithText("Earth (C-137) - Citadel of Ricks").assertIsDisplayed()
    }

}
