package com.apocrypha.view.creatureviews
import com.apocrypha.utils.DataManager
import tornadofx.*

class EditCreatureView : View("Creatures") {
    override val root = form {
        fieldset {
            listview(DataManager.getCreaturesAsObservable()) {
                onUserSelect(clickCount = 1) {
                    DataManager.editorSelection = selectionModel.selectedIndex
                }
            }
            button("Edit Creature") {
                action {
                    find(EditCreatureView::class).replaceWith(CreatureEditorView::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Delete Creature") {
                action {
                    DataManager.removeCreature(DataManager.editorSelection)
                    find(EditCreatureView::class).replaceWith(CRUDCreature::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            button("Return") {
                action {
                    find(EditCreatureView::class).replaceWith(CRUDCreature::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
    }
}
