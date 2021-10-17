package com.apocrypha.view.worldviews
import com.apocrypha.Main
import com.apocrypha.adt.Location
import com.apocrypha.utils.DataManager
import com.apocrypha.view.MainView
import javafx.scene.control.TextField
import tornadofx.*



class CreateWorldView : View("Create World") {
    private var worldNameField: TextField by singleAssign()
    override val root = form {
        fieldset {
            worldNameField = textfield("World Name...") {
            }

            button("Create World") {
                action {
                    DataManager.createWorld(worldNameField.text)
                }
            }
            button("Return") {
                action {
                    find(CreateWorldView::class).replaceWith(CRUDWorld::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}