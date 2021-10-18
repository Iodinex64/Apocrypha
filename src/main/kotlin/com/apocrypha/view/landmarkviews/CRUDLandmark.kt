package com.apocrypha.view.landmarkviews

import com.apocrypha.view.MainView
import tornadofx.*

class CRUDLandmark : View("Landmarks") {
    override val root = form {
        fieldset {
            field("Landmarks") {
                button("Create Landmark") {
                    action {
                    }
                }
                button("Edit Landmarks") {
                    action {
                    }
                }
                button("Delete Landmarks") {
                    action {
                    }
                }
                button("Return") {
                    action {
                        find(CRUDLandmark::class).replaceWith(MainView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }
            }
        }
    }
}