package com.apocrypha.view
import com.apocrypha.adt.World
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.io.FileWriter

var jo = JsonObject()
var filepath = "D:\\Github Repos\\Apocrypha\\test.json"

class MainView : View() {
    val controller: MyController by inject()
    val input = SimpleStringProperty()

    override val root = form {
        fieldset {
            field("Input") {
                textfield(input)
            }

            button("Add") {
                action {
                    controller.writeToDb(input.value)
                    input.value = ""
                }
            }

            button("Commit") {
                action {

                }
            }
        }
    }
}



class MyController: Controller() {
    fun writeToDb(inputValue: String) {
        var writer = FileWriter(filepath)
        var gson: Gson = GsonBuilder().setPrettyPrinting().create()
        println("Writing $inputValue to database!")
        gson.toJson(World(inputValue, 1), writer)
        writer.flush()
        writer.close()
    }

    fun addToJO(inputValue: String) {
        var writer = FileWriter(filepath)
        var gson: Gson = GsonBuilder().setPrettyPrinting().create()
        println("Writing $inputValue to database!")
        gson.toJson(World(inputValue, 1), writer)
        writer.flush()
        writer.close()
    }
}