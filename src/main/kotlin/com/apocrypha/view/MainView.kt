package com.apocrypha.view

import com.apocrypha.Styles
import tornadofx.*

class MainView : View("Hello TornadoFX") {
    override val root = vbox {
        button("Press me")
        label("Waiting")
    }
}
