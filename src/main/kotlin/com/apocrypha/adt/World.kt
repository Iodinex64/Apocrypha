package com.apocrypha.adt

class World constructor(var name: String) {
    var characters: MutableList<Character>? = null
    var races: MutableList<Race>? = null
    var locations: MutableList<Location>? = null
    var creatures: MutableList<Creature>? = null

    override fun toString(): String {
        return "Created World! Name='$name', Characters=$characters, Races=$races, Locations=$locations, Creatures=$creatures)"
    }
}