package com.apocrypha.adt

class World constructor(
    var name: String,
    var characters: MutableList<Character>?,
    var races: MutableList<Race>?,
    var locations: MutableList<Location>?,
    var creatures: MutableList<Creature>?,
    private var population: Int = 0
    ) {
    init {

        for (loc in locations!!) {
            population += loc.getPop()
        }
    }
}