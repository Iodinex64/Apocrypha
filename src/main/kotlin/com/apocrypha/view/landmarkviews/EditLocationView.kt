package com.apocrypha.view.landmarkviews
import com.apocrypha.utils.DataManager
import tornadofx.*

class EditLocationView : View("Landmarks") {
    override val root = form {
        fieldset {
            listview(DataManager.getLandmarksAsObservable()) {
                onUserSelect {
                    DataManager.editorSelection = selectionModel.selectedIndex
                }
            }
            button("Edit Landmark") {
                action {
                    find(EditLocationView::class).replaceWith(LandmarkEditorView::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Delete Landmark") {
                action {
                    DataManager.removeLandmark(DataManager.editorSelection)
                    DataManager.editorSelection = 0
                    find(EditLocationView::class).replaceWith(CRUDLandmark::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Return") {
                action {
                    find(EditLocationView::class).replaceWith(CRUDLandmark::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
