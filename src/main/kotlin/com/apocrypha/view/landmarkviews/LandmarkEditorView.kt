package com.apocrypha.view.landmarkviews
import com.apocrypha.adt.Landmark
import com.apocrypha.utils.DataManager
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.value.ObservableValue
import javafx.scene.control.Button
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*

class LandmarkEditorView : View("Edit Landmark") {
    private var landmarkNameField: TextField by singleAssign()
    private var landmarkBioField: TextArea by singleAssign()
    private var populationCount: TextField by singleAssign()
    private var submitButton: Button by singleAssign()
    private var locationListIndex: Int = 0

    override val root = form {
        fieldset {
            landmarkNameField = textfield(DataManager.masterLandmarks[DataManager.editorSelection].name) {
            }

            label("Population (eg. 12, 3624, 472332... etc.")
            populationCount = textfield(DataManager.masterLandmarks[DataManager.editorSelection].population.toString()) {
                action {
                }
            }

            landmarkBioField = textarea(DataManager.masterLandmarks[DataManager.editorSelection].bio) {
            }


            label("Location it's from:")
            listview(DataManager.getLocationsAsObservable()) {
                onUserSelect(clickCount = 1) {
                    locationListIndex = selectionModel.selectedIndex
                }
            }
        }

            submitButton =  button("Edit Landmark") {
                action {
                    if (populationCount.text.toIntOrNull() != null) {
                        val la = Landmark(
                            landmarkNameField.text,
                            landmarkBioField.text,
                            DataManager.getLocationAtIndex(locationListIndex).name,
                            populationCount.text.toInt()
                        )
                        DataManager.editLandmark(la)
                        find(LandmarkEditorView::class).replaceWith(CRUDLandmark::class, sizeToScene = true, centerOnScreen = true)
                    } else {
                        println("Population count is not an integer! Type something like 1252 or 35 instead.")
                    }
                }
            }
            button("Return") {
                action {
                    find(LandmarkEditorView::class).replaceWith(CRUDLandmark::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
