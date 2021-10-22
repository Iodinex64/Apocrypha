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
            locationNameField = textfield("Location name") {
            }

            locationBioField = textarea("About this location...") {

            }
            label("World this location belongs to:")
            listview(DataManager.getWorldsAsObservable()) {
                onUserSelect(clickCount = 1) {
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
