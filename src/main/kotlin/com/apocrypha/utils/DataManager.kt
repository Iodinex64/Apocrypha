package com.apocrypha.utils

import com.apocrypha.adt.*
import javafx.collections.ObservableList
import tornadofx.asObservable
import tornadofx.observable

object DataManager {
    private var worlds = ArrayList<World>()
    var characters: ArrayList<Character>? = null
    var races: ArrayList<Race>? = null
    var locations = ArrayList<Location>()
    var creatures: ArrayList<Creature>? = null

    fun createWorld(name: String) {
        val w = World(name)
        worlds.add(w)
        println("World Count: " + worlds.size)
    }

    fun createLocation(name: String, bio: String, w: World) {
        val l = Location(name, bio)
        locations.add(l)
        if (worlds.contains(w)) {
            w.locations.add(l)
            println("Locations Count: " + locations.size)
        }
    }

    fun getWorldsAsObservable(): ObservableList<World> {
        return worlds.asObservable()
    }

    fun getWorldAtIndex(index: Int): World {
        return worlds[index]
    }

    fun addCharacter(w: World, c: Character) {
        w.characters?.add(c)
    }
    fun deleteCharacter(w: World, c: Character) {
        w.characters?.remove(c)
    }
    fun addRace(w: World, r: Race) {
        w.races?.add(r)
    }
    fun addLocation(w: World, l: Location) {
        w.locations?.add(l)
    }
    fun addCreature(w: World, cr: Creature) {
        w.creatures?.add(cr)
    }
}