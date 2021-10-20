package com.apocrypha.view.characterviews
import com.apocrypha.utils.DataManager
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import com.apocrypha.adt.Character as Character
import tornadofx.*

class CharacterEditorView : View("Edit Character") {
    private var characterNameField: TextField by singleAssign()
    private var characterBioField: TextArea by singleAssign()
    private var raceListIndex: Int = 0
    private var worldListIndex: Int = 0

    override val root = form {
        fieldset {
            characterNameField = textfield(DataManager.masterCharacters[DataManager.editorSelection].name) {
            }

            characterBioField = textarea(DataManager.masterCharacters[DataManager.editorSelection].bio) {
            }

            label("Race:")
            listview(DataManager.getRacesAsObservable()) {
                onUserSelect {
                    raceListIndex = selectionModel.selectedIndex
                }
            }

            button("Edit Character") {
                action {
                    val c = Character(characterNameField.text,
                    DataManager.getRaceAtIndex(raceListIndex),
                    characterBioField.text,
                    DataManager.getWorldAtIndex(worldListIndex).name)
                    DataManager.editCharacter(c)
                    find(CharacterEditorView::class).replaceWith(CRUDCharacter::class, sizeToScene = true, centerOnScreen = true)
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
