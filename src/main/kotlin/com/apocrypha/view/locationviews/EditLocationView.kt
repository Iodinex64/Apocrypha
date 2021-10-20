package com.apocrypha.view.locationviews
import com.apocrypha.utils.DataManager
import tornadofx.*

class EditLocationView : View("Locations") {
    override val root = form {
        fieldset {
            listview(DataManager.getLocationsAsObservable()) {
                onUserSelect {
                    DataManager.editorSelection = selectionModel.selectedIndex
                }
            }
            button("Edit Location") {
                action {
                    find(EditLocationView::class).replaceWith(LocationEditorView::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Delete Location") {
                action {
                    DataManager.removeLocation(DataManager.editorSelection)
                    DataManager.editorSelection = 0
                    find(EditLocationView::class).replaceWith(CRUDLocation::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Return") {
                action {
                    find(EditLocationView::class).replaceWith(CRUDLocation::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
