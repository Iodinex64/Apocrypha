package com.apocrypha.view
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.io.FileWriter

var jo = JsonObject()
var filepath = "D:\\Github Repos\\Apocrypha\\"

class MainView : View() {
    private val controller: MyController by inject()
    private val input = SimpleStringProperty()

    override val root = form {
        fieldset {
            field("Input") {
                textfield(input)
            }

            button("Add") {
                action {
                    controller.writeToJSON(input.value)
                    input.value = ""
                }
            }
        }
    }
}



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