package com.apocrypha.view.creatureviews

import com.apocrypha.view.MainView
import tornadofx.*

class CRUDCreature : View("Creatures") {
    override val root = form {
        fieldset {
            field("Creatures") {
                button("Create Creature") {
                    action {
                        find(CRUDCreature::class).replaceWith(CreateCreatureView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }
                button("Edit Creatures") {
                    action {
                        find(CRUDCreature::class).replaceWith(EditCreatureView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }

                button("Return") {
                    action {
                        find(CRUDCreature::class).replaceWith(MainView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }
            }
        }
    }
}