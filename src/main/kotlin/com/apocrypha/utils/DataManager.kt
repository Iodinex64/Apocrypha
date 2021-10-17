package com.apocrypha.utils

import com.apocrypha.adt.*

object DataManager {
    var worlds: ArrayList<World>? = null
    var characters: ArrayList<Character>? = null
    var races: ArrayList<Race>? = null
    var locations: ArrayList<Location>? = null
    var creatures: ArrayList<Creature>? = null

    fun createWorld(name: String) {
        var w = World(name)
        worlds?.add(w)
        println(worlds?.size)
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