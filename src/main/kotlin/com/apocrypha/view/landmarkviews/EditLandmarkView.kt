package com.apocrypha.view.landmarkviews
import com.apocrypha.utils.DataManager
import tornadofx.*

class EditLandmarkView : View("Landmarks") {
    override val root = form {
        fieldset {
            listview(DataManager.getLandmarksAsObservable()) {
                onUserSelect(clickCount = 1) {
                    DataManager.editorSelection = selectionModel.selectedIndex
                }
            }
            button("Edit Landmark") {
                action {
                    find(EditLandmarkView::class).replaceWith(LandmarkEditorView::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Delete Landmark") {
                action {
                    DataManager.removeLandmark(DataManager.editorSelection)
                    find(EditLandmarkView::class).replaceWith(CRUDLandmark::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Return") {
                action {
                    find(EditLandmarkView::class).replaceWith(CRUDLandmark::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
