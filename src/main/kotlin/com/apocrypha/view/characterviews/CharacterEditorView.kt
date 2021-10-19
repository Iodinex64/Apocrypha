package com.apocrypha.view.characterviews
import com.apocrypha.utils.DataManager
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*

class CharacterEditorView : View("Edit Character") {
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
                onUserSelect {
                    worldListIndex = selectionModel.selectedIndex
                }
            }
            label("Race:")
            listview(DataManager.getRacesAsObservable()) {
                onUserSelect {
                    raceListIndex = selectionModel.selectedIndex
                }
            }

            button("Edit Character") {
                action {
                    DataManager.createCharacter(characterNameField.text,
                        DataManager.getRaceAtIndex(raceListIndex),
                        DataManager.getWorldAtIndex(worldListIndex),
                        characterBioField.text)

                }
            }
            button("Return") {
                action {
                    find(CharacterEditorView::class).replaceWith(CRUDCharacter::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
