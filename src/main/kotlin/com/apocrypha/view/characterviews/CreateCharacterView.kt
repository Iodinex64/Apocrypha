package com.apocrypha.view.characterviews
import com.apocrypha.utils.DataManager
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*

class CreateCharacterView : View("Create Character") {
    private var characterNameField: TextField by singleAssign()
    private var characterBioField: TextArea by singleAssign()
    private var raceListIndex: Int = 0
    private var worldListIndex: Int = 0

    override val root = form {
        fieldset {
            characterNameField = textfield("Character Name...") {
            }

            characterBioField = textarea("About this Character...") {
            }
            label("World of origin:")
            listview(DataManager.getWorldsAsObservable()) {
                onUserSelect(clickCount = 1) {
                    worldListIndex = selectionModel.selectedIndex
                }
            }
            label("Race:")
            listview(DataManager.getRacesAsObservable()) {
                onUserSelect(clickCount = 1) {
                    raceListIndex = selectionModel.selectedIndex
                }
            }

            button("Create Character") {
                action {
                    DataManager.createCharacter(characterNameField.text,
                        DataManager.getRaceAtIndex(raceListIndex),
                        DataManager.getWorldAtIndex(worldListIndex),
                        characterBioField.text)

                }
            }
            button("Return") {
                action {
                    find(CreateCharacterView::class).replaceWith(CRUDCharacter::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
