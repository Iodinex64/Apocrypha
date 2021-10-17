package com.apocrypha.view.locationviews
import com.apocrypha.Main
import com.apocrypha.adt.Location
import com.apocrypha.adt.World
import com.apocrypha.utils.DataManager
import com.apocrypha.view.MainView
import javafx.scene.control.TextField
import tornadofx.*

class CreateLocationView : View("Create Location") {
    private var worldNameField: TextField by singleAssign()
    override val root = form {
        fieldset {
            worldNameField = textfield("Location Name...") {
            }
            listview<World> {
                for (worlds in DataManager.worlds!!) {
                    items.add(worlds)
                }
            }

            button("Create Location") {
                action {
                    DataManager.createWorld(worldNameField.text)
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