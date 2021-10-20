package com.apocrypha.view
import com.apocrypha.utils.DataManager
import com.apocrypha.view.raceviews.CRUDRace
import tornadofx.*

class Search : View("View All") {
    override val root = form {
        fieldset {
            label("Worlds:")
            listview(DataManager.getWorldsAsObservable())
            label("Characters:")
            listview(DataManager.getCharactersAsObservable())
            label("Locations:")
            listview(DataManager.getLocationsAsObservable())
            label("Creatures:")
            listview(DataManager.getCreaturesAsObservable())
            label("Races:")
            listview(DataManager.getRacesAsObservable())
            label("Landmarks:")
            listview(DataManager.getLandmarksAsObservable())
        }
        button("Return") {
            action {
                find(Search::class).replaceWith(MainView::class, sizeToScene = true, centerOnScreen = true)
            }
        }
    }
}

