package com.apocrypha.utils

import com.apocrypha.adt.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import javafx.collections.ObservableList
import tornadofx.asObservable
import java.io.FileWriter

object DataManager {
    var filepath = "D:\\Github Repos\\Apocrypha\\"

    var masterWorlds = ArrayList<World>()
    var masterCharacters = ArrayList<Character>()
    var masterRaces = ArrayList<Race>()
    var masterLocations = ArrayList<Location>()
    var masterCreatures = ArrayList<Creature>()
    var masterLandmarks = ArrayList<Landmark>()

    fun createWorld(name: String) {
        val w = World(name)
        masterWorlds.add(w)
        println("World Count: " + masterWorlds.size)
    }

    fun createLocation(name: String, bio: String, w: World) {
        val l = Location(name, bio)
        masterLocations.add(l)
        if (masterWorlds.contains(w)) {
            w.locations.add(l)
            println("Locations Count: " + masterLocations.size)
        }
    }

    fun createCharacter(name: String, race: Race, world: World, bio: String) {
        val c = Character(name, race, bio)
        masterCharacters.add(c)
        if (masterWorlds.contains(world)) {
            world.characters.add(c)
        }
        println("Characters Count: " + masterCharacters.size)
    }

    fun createCreature(name: String, home: Location, bio: String) {
        val cr = Creature(name, bio)
        masterCreatures.add(cr)
        if (masterLocations.contains(home)) {
            home.addCreature(cr)
        }
        println("Creatures Count: " + masterCreatures.size)
    }

    fun createRace(name: String, home: Location, bio: String) {
        val r = Race(name, bio)
        masterRaces.add(r)
        if (masterLocations.contains(home)) {
            home.races.add(r)
        }
        println("Races Count: " + masterRaces.size)
    }

    fun createLandmark(name: String, bio: String, population: Int, loc: Location) {
        val la = Landmark(name, bio, population)
        masterLandmarks.add(la)
        if (masterLocations.contains(loc)) {
            loc.landmarks.add(la)
            println("Landmarks Count: " + masterLandmarks.size)
        }
    }

    fun getWorldsAsObservable(): ObservableList<World> {
        return masterWorlds.asObservable()
    }

    fun getRacesAsObservable(): ObservableList<Race> {
        return masterRaces.asObservable()
    }

    fun getLocationsAsObservable(): ObservableList<Location> {
        return masterLocations.asObservable()
    }

    fun getWorldAtIndex(index: Int): World {
        return masterWorlds[index]
    }

    fun getRaceAtIndex(index: Int): Race {
        return masterRaces[index]
    }

    fun getLocationAtIndex(index: Int): Location {
        return masterLocations[index]
    }

    fun addCharacter(w: World, c: Character) {
        w.characters.add(c)
    }
    fun deleteCharacter(w: World, c: Character) {
        w.characters.remove(c)
    }

    fun addLocation(w: World, l: Location) {
        w.locations.add(l)
    }

    fun saveToJSON() {
        val writer = FileWriter(filepath + "ApocryphaWorldList.json")
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()
        println("Writing worlds to database...")
        gson.toJson(masterWorlds, writer)
        writer.flush()
        writer.close()
    }

    fun readFromJSON() {

    }
}