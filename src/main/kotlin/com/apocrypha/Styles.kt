package com.apocrypha

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
    }

    init {
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }

        form {
            padding = box(25.px)
            prefWidth = 720.px
        }

        button {
            padding = box(10.0.px)
            prefWidth = 250.px
        }

        textArea {
            prefHeight = 100.px
        }

        listView {
            prefHeight = 100.px
        }

    }
}