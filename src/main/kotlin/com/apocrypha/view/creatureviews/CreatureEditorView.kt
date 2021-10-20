package com.apocrypha.view.creatureviews
import com.apocrypha.adt.Creature
import com.apocrypha.utils.DataManager
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*

class CreatureEditorView : View("Edit Creature") {
private var creatureNameField: TextField by singleAssign()
private var creatureBioField: TextArea by singleAssign()
private var locationListIndex: Int = 0

override val root = form {
    fieldset {
        creatureNameField = textfield(DataManager.masterCreatures[DataManager.editorSelection].name) {
        }

        creatureBioField = textarea(DataManager.masterCreatures[DataManager.editorSelection].bio) {
        }
        label("Place of origin:")
        listview(DataManager.getLocationsAsObservable()) {
            onUserSelect {
                locationListIndex = selectionModel.selectedIndex
            }
        }
    }

        button("Edit Creature") {
            action {
                val cr = Creature(creatureNameField.text,
                    DataManager.getLocationAtIndex(locationListIndex).name,
                    creatureBioField.text)
                DataManager.editCreature(cr)
            }
        }
        button("Return") {
            action {
                find(CreatureEditorView::class).replaceWith(CRUDCreature::class, sizeToScene = true, centerOnScreen = true)
            }
        }
    }
}
