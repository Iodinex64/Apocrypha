package com.apocrypha.view.worldviews
import com.apocrypha.adt.World
import com.apocrypha.utils.DataManager
import javafx.scene.control.TextField
import tornadofx.*

class WorldEditorView : View("Edit World") {
    private var worldNameField: TextField by singleAssign()
    override val root = form {
        fieldset {
            worldNameField = textfield(DataManager.masterWorlds[DataManager.editorSelection].name) {
            }

            button("Edit World") {
                action {
                    DataManager.editWorld(World(worldNameField.text))
                }
            }
            button("Return") {
                action {
                    find(WorldEditorView::class).replaceWith(CRUDWorld::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}