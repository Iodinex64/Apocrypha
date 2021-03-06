package com.apocrypha.view.locationviews

import com.apocrypha.utils.DataManager
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
                        find(CRUDLocation::class).replaceWith(EditLocationView::class, sizeToScene = true, centerOnScreen = true)
                        DataManager.editorSelection = -1
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