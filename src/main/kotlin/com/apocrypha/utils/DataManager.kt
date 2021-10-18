package com.apocrypha.utils

import com.apocrypha.adt.*
import javafx.collections.ObservableList
import tornadofx.asObservable

object DataManager {
    var worlds = ArrayList<World>()
    var characters = ArrayList<Character>()
    var races = ArrayList<Race>()
    var locations = ArrayList<Location>()
    var creatures = ArrayList<Creature>()
    var landmarks = ArrayList<Landmark>()

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

    fun createCharacter(name: String, race: Race, home: Location, bio: String) {
        val c = Character(name, race, home, bio)
        characters.add(c)
        println("Characters Count: " + characters.size)
    }

    fun createCreature(name: String, home: Location, bio: String) {
        val cr = Creature(name, home, bio)
        creatures.add(cr)
        println("Creatures Count: " + characters.size)
    }

    fun createRace(name: String, home: Location, bio: String) {
        val r = Race(name, home, bio)
        races.add(r)
        println("Races Count: " + races.size)
    }

    fun createLandmark(name: String, bio: String, population: Int, loc: Location) {
        val la = Landmark(name, bio, population)
        landmarks.add(la)
        if (locations.contains(loc)) {
            loc.landmarks.add(la)
            println("Landmarks Count: " + landmarks.size)
        }
    }

    fun getWorldsAsObservable(): ObservableList<World> {
        return worlds.asObservable()
    }

    fun getRacesAsObservable(): ObservableList<Race> {
        return races.asObservable()
    }

    fun getLocationsAsObservable(): ObservableList<Location> {
        return locations.asObservable()
    }

    fun getWorldAtIndex(index: Int): World {
        return worlds[index]
    }

    fun getRaceAtIndex(index: Int): Race {
        return races[index]
    }

    fun getLocationAtIndex(index: Int): Location {
        return locations[index]
    }

    fun addCharacter(w: World, c: Character) {
        w.characters.add(c)
    }
    fun deleteCharacter(w: World, c: Character) {
        w.characters.remove(c)
    }
    fun addRace(w: World, r: Race) {
        w.races.add(r)
    }
    fun addLocation(w: World, l: Location) {
        w.locations.add(l)
    }
    fun addCreature(w: World, cr: Creature) {
        w.creatures.add(cr)
    }
}