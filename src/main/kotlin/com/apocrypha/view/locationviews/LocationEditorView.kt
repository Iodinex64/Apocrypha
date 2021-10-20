package com.apocrypha.view.locationviews
import com.apocrypha.adt.Character
import com.apocrypha.adt.Location
import com.apocrypha.adt.World
import com.apocrypha.utils.DataManager
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.control.ListView
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*

class LocationEditorView : View("Edit Location") {
    private var locationNameField: TextField by singleAssign()
    private var locationBioField: TextArea by singleAssign()
    var worldListIndex: Int = 0

    override val root = form {
        fieldset {
            locationNameField = textfield(DataManager.masterLocations[DataManager.editorSelection].name) {
            }

            locationBioField = textarea(DataManager.masterLocations[DataManager.editorSelection].bio) {

            }
            label("World this location belongs to:")
            listview(DataManager.getWorldsAsObservable()) {
                onUserSelect {
                    worldListIndex = selectionModel.selectedIndex
                }
            }

            button("Edit Location") {
                action {
                    val l = Location(locationNameField.text,
                        locationBioField.text,
                    DataManager.getWorldAtIndex(worldListIndex).name)
                    DataManager.editLocation(l)
                }
            }
            button("Return") {
                action {
                    find(LocationEditorView::class).replaceWith(CRUDLocation::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
