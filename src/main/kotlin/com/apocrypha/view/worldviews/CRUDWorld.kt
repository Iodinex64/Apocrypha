package com.apocrypha.view.worldviews
import com.apocrypha.utils.DataManager
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
                        find(CRUDWorld::class).replaceWith(EditWorldView::class, sizeToScene = true, centerOnScreen = true)
                        DataManager.editorSelection = -1
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