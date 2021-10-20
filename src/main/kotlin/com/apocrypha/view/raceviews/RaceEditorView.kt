package com.apocrypha.view.raceviews

import com.apocrypha.adt.Race
import com.apocrypha.utils.DataManager
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*

class RaceEditorView : View("Create race") {
    private var raceNameField: TextField by singleAssign()
    private var raceBioField: TextArea by singleAssign()
    private var locationListIndex: Int = 0

    override val root = form {
        fieldset {
            raceNameField = textfield(DataManager.masterRaces[DataManager.editorSelection].name) {
            }

            raceBioField = textarea(DataManager.masterRaces[DataManager.editorSelection].bio) {
            }

            label("Place of origin:")
            listview(DataManager.getLocationsAsObservable()) {
                onUserSelect {
                    locationListIndex = selectionModel.selectedIndex
                }
            }

            button("Edit race") {
                action {
                    val r = Race(raceNameField.text,
                        DataManager.getLocationAtIndex(locationListIndex).name,
                        raceBioField.text)
                    DataManager.editRace(r)

                }
            }
            button("Return") {
                action {
                    find(RaceEditorView::class).replaceWith(CRUDRace::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
