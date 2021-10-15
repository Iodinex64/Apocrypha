package com.apocrypha.adt

class World constructor(
    var name: String,
    var characters: List<Character>?,
    var races: List<Race>?,
    var locations: List<Location>?,
    var creatures: List<Creature>?,
    private var population: Int = 0
    ) {
    init {

        for (loc in locations!!) {
            population += loc.getPop()
        }
    }
}