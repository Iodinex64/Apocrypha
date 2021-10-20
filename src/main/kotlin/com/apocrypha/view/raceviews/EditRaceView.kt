package com.apocrypha.view.raceviews
import com.apocrypha.utils.DataManager
import tornadofx.*

class EditRaceView : View("Races") {
    override val root = form {
        fieldset {
            listview(DataManager.getRacesAsObservable()) {
                onUserSelect {
                    DataManager.editorSelection = selectionModel.selectedIndex
                }
            }
            button("Edit Race") {
                action {
                    find(EditRaceView::class).replaceWith(RaceEditorView::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Delete Race") {
                action {
                    DataManager.removeRace(DataManager.editorSelection)
                    DataManager.editorSelection = 0
                    find(EditRaceView::class).replaceWith(CRUDRace::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Return") {
                action {
                    find(EditRaceView::class).replaceWith(CRUDRace::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
