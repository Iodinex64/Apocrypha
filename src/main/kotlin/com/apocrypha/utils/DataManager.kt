package com.apocrypha.utils

import com.apocrypha.adt.*

class DataManager {
    var worlds: MutableList<World>? = null
    var characters: MutableList<Character>? = null
    var races: MutableList<Race>? = null
    var locations: MutableList<Location>? = null
    var creatures: MutableList<Creature>? = null

    init {
        for (world in worlds!!) {
            for (character in world.characters!!) {
                //finish later
            }
        }
    }
}