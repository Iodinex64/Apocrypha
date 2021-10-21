package com.apocrypha.view.landmarkviews
import com.apocrypha.utils.DataManager
    import javafx.scene.control.TextArea
    import javafx.scene.control.TextField
    import tornadofx.*

class CreateLandmarkView : View("Create Landmark") {
    private var landmarkNameField: TextField by singleAssign()
    private var landmarkBioField: TextArea by singleAssign()
    private var populationCount: TextField by singleAssign()
    private var locationListIndex: Int = 0

    override val root = form {
        fieldset {
            landmarkNameField = textfield("Landmark Name...") {
            }

            label("Population (eg. 12, 3624, 472332... etc.")
            populationCount = textfield() {
            }

            landmarkBioField = textarea("About this Landmark...") {
            }


            label("Location it's from:")
            listview(DataManager.getLocationsAsObservable()) {
                onUserSelect {
                    locationListIndex = selectionModel.selectedIndex
                }
            }
        }

            button("Create Landmark") {
                action {
                    if (populationCount.text.toIntOrNull() != null) {
                        DataManager.createLandmark(
                            landmarkNameField.text,
                            landmarkBioField.text,
                            populationCount.text.toInt(),
                            DataManager.getLocationAtIndex(locationListIndex)
                        )
                        find(CreateLandmarkView::class).replaceWith(CRUDLandmark::class, sizeToScene = true, centerOnScreen = true)
                    } else {
                        println("Population count is not an integer! Type something like 1252 or 35 instead.")
                    }
                }
            }
            button("Return") {
                action {
                    find(CreateLandmarkView::class).replaceWith(CRUDLandmark::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
