package com.apocrypha.view.characterviews

import com.apocrypha.utils.DataManager
import com.apocrypha.view.MainView
import tornadofx.*

class CRUDCharacter : View("Characters") {
    override val root = form {
        fieldset {
            field("Characters") {
                button("Create Character") {
                    action {
                        find(CRUDCharacter::class).replaceWith(CreateCharacterView::class, sizeToScene = true, centerOnScreen = true)
                    }
                }
                button("Edit Characters") {
                    action {
                        find(CRUDCharacter::class).replaceWith(EditCharacterView::class, sizeToScene = true, centerOnScreen = true)
                        DataManager.editorSelection = -1
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