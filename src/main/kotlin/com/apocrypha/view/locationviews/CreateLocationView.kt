package com.apocrypha.view.locationviews
import com.apocrypha.utils.DataManager
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*

class CreateLocationView : View("Create Location") {
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

            button("Create Location") {
                action {
                    DataManager.createLocation(locationNameField.text,
                        locationBioField.text,
                        DataManager.getWorldAtIndex(worldListIndex))
                }
            }
            button("Return") {
                action {
                    find(CreateLocationView::class).replaceWith(CRUDLocation::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
