package com.apocrypha.utils

import com.apocrypha.adt.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import javafx.collections.ObservableList
import tornadofx.asObservable
import java.io.FileWriter
import java.io.Reader
import java.nio.file.Files
import java.nio.file.Paths


object DataManager {
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
            loc.calculatePop()
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
        val writer = FileWriter("ApocryphaDatabase.json")
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()
        println("Writing to database...")
        gson.toJson(masterWorlds, writer)
        writer.flush()
        writer.close()
        println("Data successfully stored.")
    }

    fun readFromJSON() {
        try {
            val reader: Reader = Files.newBufferedReader(Paths.get("ApocryphaDatabase.json"))
            val jsonWorlds: ArrayList<World> = Gson().fromJson(reader, object : TypeToken<ArrayList<World?>?>() {}.type)
            masterWorlds.addAll(jsonWorlds)

            //repopulate master lists
            for (wor in jsonWorlds) {
                masterLocations.addAll(wor.locations)
                masterCharacters.addAll(wor.characters)
            }
            for (loc in masterLocations) {
                masterRaces.addAll(loc.races)
                masterLandmarks.addAll(loc.landmarks)
                masterCreatures.addAll(loc.creatures)
            }
            //we're done
            reader.close()

            println("Worlds loaded: " + masterWorlds.size)
            println("Locations loaded: " + masterLocations.size)
            println("Characters loaded: " + masterCharacters.size)
            println("Races loaded: " + masterRaces.size)
            println("Creatures loaded: " + masterCreatures.size)
            println("Landmarks loaded: " + masterLandmarks.size)
        } catch (e: Exception) {
            println("Couldn't load from database, making new one...")
            saveToJSON()
            readFromJSON()
        }
    }
}