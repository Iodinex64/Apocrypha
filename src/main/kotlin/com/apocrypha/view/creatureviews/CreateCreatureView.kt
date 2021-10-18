package com.apocrypha.view.creatureviews
import com.apocrypha.utils.DataManager
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*

class CreateCreatureView : View("Create Creature") {
private var creatureNameField: TextField by singleAssign()
private var creatureBioField: TextArea by singleAssign()
private var locationListIndex: Int = 0

override val root = form {
    fieldset {
        creatureNameField = textfield("Creature Name...") {
        }

        creatureBioField = textarea("About this Creature...") {
        }
        label("Place of origin:")
        listview(DataManager.getLocationsAsObservable()) {
            onUserSelect {
                locationListIndex = selectionModel.selectedIndex
            }
        }
    }

        button("Create Creature") {
            action {
                DataManager.createCreature(creatureNameField.text,
                    DataManager.getLocationAtIndex(locationListIndex),
                    creatureBioField.text)
            }
        }
        button("Return") {
            action {
                find(CreateCreatureView::class).replaceWith(CRUDCreature::class, sizeToScene = true, centerOnScreen = true)
            }
        }
    }
}
