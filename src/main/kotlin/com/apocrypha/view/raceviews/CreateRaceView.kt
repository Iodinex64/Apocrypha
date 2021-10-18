package com.apocrypha.view.raceviews

import com.apocrypha.utils.DataManager
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*

class CreateRaceView : View("Create race") {
    private var raceNameField: TextField by singleAssign()
    private var raceBioField: TextArea by singleAssign()
    private var locationListIndex: Int = 0

    override val root = form {
        fieldset {
            raceNameField = textfield("Race Name...") {
            }

            raceBioField = textarea("About this Race...") {
            }
            label("Place of origin:")
            listview(DataManager.getLocationsAsObservable()) {
                onUserSelect {
                    locationListIndex = selectionModel.selectedIndex
                }
            }

            button("Create race") {
                action {
                    DataManager.createRace(raceNameField.text,
                        DataManager.getLocationAtIndex(locationListIndex),
                        raceBioField.text)

                }
            }
            button("Return") {
                action {
                    find(CreateRaceView::class).replaceWith(CRUDRace::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
