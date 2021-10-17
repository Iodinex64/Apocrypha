package com.apocrypha.utils

import com.apocrypha.adt.*

object DataManager {
    var worlds: MutableList<World>? = null
    var characters: MutableList<Character>? = null
    var races: MutableList<Race>? = null
    var locations: MutableList<Location>? = null
    var creatures: MutableList<Creature>? = null

    fun createWorld(name: String) {
        var w = World(name)
        worlds?.add(w)
        println(w)
    }

    fun addCharacter(w: World, c: Character) {
        w.characters?.add(c)
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