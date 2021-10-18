package com.apocrypha.view.locationviews
import com.apocrypha.adt.World
import com.apocrypha.utils.DataManager
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.control.ListView
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*

class CreateLocationView : View("Create Location") {
    private var locationNameField: TextField by singleAssign()
    private var locationBioField: TextArea by singleAssign()
    private var worldList: ListView<World> = ListView<World>()
    var worldListIndex: Int = 0

    override val root = form {
        fieldset {
            locationNameField = textfield("Location Name...") {
            }

            locationBioField = textarea("About this location...") {

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
