package com.apocrypha.adt

class World constructor(var name: String) {
    var characters = ArrayList<Character>()
    var races = ArrayList<Race>()
    var locations = ArrayList<Location>()
    var creatures =  ArrayList<Creature>()

    override fun toString(): String {
        return "World Name='$name', Characters=$characters, Races=$races, Locations=$locations, Creatures=$creatures)"
    }
}