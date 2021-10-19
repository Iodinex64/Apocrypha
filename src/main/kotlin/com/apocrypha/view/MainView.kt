package com.apocrypha.view
import com.apocrypha.adt.World
import com.apocrypha.utils.DataManager
import com.apocrypha.view.characterviews.CRUDCharacter
import com.apocrypha.view.creatureviews.CRUDCreature
import com.apocrypha.view.landmarkviews.CRUDLandmark
import com.apocrypha.view.locationviews.CRUDLocation
import com.apocrypha.view.raceviews.CRUDRace
import com.apocrypha.view.worldviews.CRUDWorld
import javafx.geometry.Pos
import tornadofx.*



class MainView : View("Apocrypha Main Menu") {
    init {
        DataManager.readFromJSON()
    }
    override val root = form {
        fieldset {
            field("Apocrypha-PROTOTYPE") {
                button("Save to JSON") {
                    action {
                        DataManager.saveToJSON()
                    }
                }
                vbox(alignment = Pos.CENTER) {
                    button("Worlds") {
                        action {
                            runLater {
                                find(MainView::class).replaceWith(CRUDWorld::class, sizeToScene = true, centerOnScreen = true)
                            }
                        }
                    }
                    button("Characters") {
                        action {
                            runLater {
                                find(MainView::class).replaceWith(CRUDCharacter::class, sizeToScene = true, centerOnScreen = true)
                            }
                        }
                    }
                    button("Races") {
                        action {
                            runLater {
                                find(MainView::class).replaceWith(CRUDRace::class, sizeToScene = true, centerOnScreen = true)
                            }
                        }
                    }
                    button("Locations") {
                        action {
                            runLater {
                                find(MainView::class).replaceWith(CRUDLocation::class, sizeToScene = true, centerOnScreen = true)
                            }
                        }
                    }
                    button("Creatures") {
                        action {
                            runLater {
                                find(MainView::class).replaceWith(CRUDCreature::class, sizeToScene = true, centerOnScreen = true)
                            }
                        }
                    }
                    button("Landmarks") {
                        action {
                            runLater {
                                find(MainView::class).replaceWith(CRUDLandmark::class, sizeToScene = true, centerOnScreen = true)
                            }
                        }
                    }
                }
            }
        }
    }
}

/*
class MyController: Controller() {
    fun writeToJSON(inputValue: String) {
        var writer = FileWriter(filepath)
        var gson: Gson = GsonBuilder().setPrettyPrinting().create()
        println("Writing $inputValue to database!")
        //gson.toJson(World(inputValue), writer)
        writer.flush()
        writer.close()
    }

    fun addToJO(inputValue: String) {
        var writer = FileWriter(filepath)
        var gson: Gson = GsonBuilder().setPrettyPrinting().create()
        println("Writing $inputValue to database!")
        //gson.toJson(World(inputValue), writer)
        writer.flush()
        writer.close()
    }
}
*/