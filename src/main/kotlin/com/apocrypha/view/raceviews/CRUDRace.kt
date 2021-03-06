package com.apocrypha.view.raceviews

import com.apocrypha.utils.DataManager
import com.apocrypha.view.MainView
import tornadofx.*

class CRUDRace : View("Races") {
    override val root = form {
        fieldset {
            field("Races") {
                button("Create Race") {
                    action {
                        find(CRUDRace::class).replaceWith(CreateRaceView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }
                button("Edit Races") {
                    action {
                        find(CRUDRace::class).replaceWith(EditRaceView::class, sizeToScene = true, centerOnScreen = true)
                        DataManager.editorSelection = -1
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