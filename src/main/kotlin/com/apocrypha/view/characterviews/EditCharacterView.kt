package com.apocrypha.view.characterviews
import com.apocrypha.utils.DataManager
import tornadofx.*

class EditCharacterView : View("Characters") {
    override val root = form {
        fieldset {
            listview(DataManager.getCharactersAsObservable()) {
                onUserSelect {
                    DataManager.editSelection = selectionModel.selectedIndex
                }
            }
            button("Edit Character") {
                action {
                    //find(EditCharacterView::class).replaceWith(CharacterEditorView::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Delete Character") {
                action {
                    DataManager.removeCharacter(DataManager.editSelection)
                    DataManager.editSelection = 0
                    find(EditCharacterView::class).replaceWith(CRUDCharacter::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Return") {
                action {
                    find(EditCharacterView::class).replaceWith(CRUDCharacter::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
