package com.apocrypha.view.worldviews
import com.apocrypha.view.MainView
import tornadofx.*

class CRUDWorld : View("Worlds") {
    override val root = form {
        fieldset {
            field("Worlds") {
                button("Create World") {
                    action {
                        find(CRUDWorld::class).replaceWith(CreateWorldView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }
                button("Edit Worlds") {
                    action {
                    }
                }
                button("Delete Worlds") {
                    action {
                    }
                }
                button("Return") {
                    action {
                        find(CRUDWorld::class).replaceWith(MainView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }
            }

        }
    }
}