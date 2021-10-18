package com.apocrypha.view.characterviews
import com.apocrypha.adt.Race
import com.apocrypha.adt.World
import com.apocrypha.utils.DataManager
import javafx.scene.control.ListView
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*

class CreateCharacterView : View("Create Character") {
    private var characterNameField: TextField by singleAssign()
    private var characterBioField: TextArea by singleAssign()
    private var raceListIndex: Int = 0
    private var locationListIndex: Int = 0

    override val root = form {
        fieldset {
            characterNameField = textfield("Character Name...") {
            }

            characterBioField = textarea("About this Character...") {
            }

            listview(DataManager.getLocationsAsObservable()) {
                onUserSelect {
                    locationListIndex = selectionModel.selectedIndex
                }
            }

            listview(DataManager.getRacesAsObservable()) {
                onUserSelect {
                    raceListIndex = selectionModel.selectedIndex
                }
            }

            button("Create Character") {
                action {
                    DataManager.createCharacter(characterNameField.text,
                        DataManager.getRaceAtIndex(raceListIndex),
                        DataManager.getLocationAtIndex(locationListIndex),
                        characterBioField.text)

                }
            }
            button("Return") {
                action {
                    find(CreateCharacterView::class).replaceWith(CRUDCharacter::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
