package com.apocrypha.view.landmarkviews
import com.apocrypha.adt.Landmark
import com.apocrypha.utils.DataManager
    import javafx.scene.control.TextArea
    import javafx.scene.control.TextField
    import tornadofx.*

class LandmarkEditorView : View("Edit Landmark") {
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

            button("Edit Landmark") {
                action {
                    val la = Landmark(
                        landmarkNameField.text,
                        landmarkBioField.text,
                        DataManager.getLocationAtIndex(locationListIndex).name,
                        populationCount.text.toInt())
                    DataManager.editLandmark(la)
                }
            }
            button("Return") {
                action {
                    find(LandmarkEditorView::class).replaceWith(CRUDLandmark::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
