package com.apocrypha.view.characterviews

import com.apocrypha.view.MainView
import tornadofx.*

class CRUDCharacter : View("Characters") {
    override val root = form {
        fieldset {
            field("Characters") {
                button("Create Character") {
                    action {
                    }
                }
                button("Edit Characters") {
                    action {
                    }
                }
                button("Delete Characters") {
                    action {
                    }
                }
                button("Return") {
                    action {
                        find(CRUDCharacter::class).replaceWith(MainView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }
            }
        }
    }
}