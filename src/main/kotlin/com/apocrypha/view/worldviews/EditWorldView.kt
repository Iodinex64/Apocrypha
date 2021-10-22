package com.apocrypha.view.worldviews
import com.apocrypha.utils.DataManager
import tornadofx.*

class EditWorldView : View("Worlds") {

    override val root = form {
        fieldset {
            listview(DataManager.getWorldsAsObservable()) {
                onUserSelect(clickCount = 1) {
                    DataManager.editorSelection = selectionModel.selectedIndex
                }
            }
            button("Edit World") {
                action {
                    find(EditWorldView::class).replaceWith(WorldEditorView::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Delete World") {
                action {
                    DataManager.removeWorld(DataManager.editorSelection)
                    find(EditWorldView::class).replaceWith(CRUDWorld::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Return") {
                action {
                    find(EditWorldView::class).replaceWith(CRUDWorld::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
