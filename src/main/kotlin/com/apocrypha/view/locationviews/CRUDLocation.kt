package com.apocrypha.view.locationviews

import com.apocrypha.view.MainView
import tornadofx.*

class CRUDLocation : View("Locations") {
    override val root = form {
        fieldset {
            field("Locations") {
                button("Create Location") {
                    action {
                        find(CRUDLocation::class).replaceWith(CreateLocationView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }
                button("Edit Locations") {
                    action {
                    }
                }

                button("Return") {
                    action {
                        find(CRUDLocation::class).replaceWith(MainView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }
            }
        }
    }
}