package com.apocrypha.view.landmarkviews

import com.apocrypha.view.MainView
import tornadofx.*

class CRUDLandmark : View("Landmarks") {
    override val root = form {
        fieldset {
            field("Landmarks") {
                button("Create Landmark") {
                    action {
                        find(CRUDLandmark::class).replaceWith(CreateLandmarkView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }
                button("Edit Landmarks") {
                    action {
                        find(CRUDLandmark::class).replaceWith(EditLandmarkView::class, sizeToScene = true, centerOnScreen = true)
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