package com.apocrypha.view
import com.apocrypha.utils.DataManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import tornadofx.*
import java.io.FileWriter

var filepath = "D:\\Github Repos\\Apocrypha\\"
var controller = ViewController()
var dm = DataManager()

class MainView : View() {
    override val root = form {
        fieldset {
            field("Apocrypha-PROTOTYPE") {
                vbox(alignment = Pos.CENTER) {
                    button("Worlds") {
                        action {
                            controller.createWorldWindow()
                        }
                    }
                    button("Characters") {
                        action {
                        }
                    }
                    button("Races") {
                        action {
                        }
                    }
                    button("Locations") {
                        action {
                        }
                    }
                    button("Creatures") {
                        action {
                        }
                    }
                }
            }
        }
    }
}

class ViewController: Controller() {
    fun createWorldWindow() {
        runLater {
            find(MainView::class).replaceWith(CreateWorldView::class, sizeToScene = true, centerOnScreen = true)
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