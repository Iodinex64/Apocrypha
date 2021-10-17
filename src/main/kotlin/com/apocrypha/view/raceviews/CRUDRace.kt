package com.apocrypha.view.raceviews

import com.apocrypha.view.MainView
import tornadofx.*

class CRUDRace : View("Races") {
    override val root = form {
        fieldset {
            field("Races") {
                button("Create Race") {
                    action {
                    }
                }
                button("Edit Races") {
                    action {
                    }
                }
                button("Delete Races") {
                    action {
                    }
                }
                button("Return") {
                    action {
                        find(CRUDRace::class).replaceWith(MainView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }
            }
        }
    }
}