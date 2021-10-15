package com.apocrypha.view

import com.apocrypha.adt.Character
import com.apocrypha.adt.Creature
import com.apocrypha.adt.Location
import com.apocrypha.adt.Race
import com.apocrypha.view.MainView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import tornadofx.*
import java.io.FileWriter

class CreateWorldView : View("Create World") {
    override val root = form {
        fieldset {
            field("Create A World") {
                textfield("My New World") {
                }
                button("Create World") {
                    action {
                    }
                }
            }
        }
    }
}