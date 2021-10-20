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

    var editorSelection = 0

    fun createWorld(name: String) {
        val w = World(name)
        masterWorlds.add(w)
        println("World Count: " + masterWorlds.size)
    }

    fun editWorld(w: World) {
        println("Replaced " + masterWorlds[editorSelection].toString())
        masterWorlds[editorSelection] = w
        println("With $w")
    }

    fun editCharacter(newC: Character) {
        println("Replaced " + masterCharacters[editorSelection].toString())
        for (world in masterWorlds) {
            if (world.characters.contains(masterCharacters[editorSelection])) {
                val i = world.characters.indexOf(masterCharacters[editorSelection])
                world.characters[i] = newC
                masterCharacters[editorSelection] = newC
                println("With $newC")
            }
        }
    }

    fun editLocation(newL: Location) {
        println("Replaced " + masterLocations[editorSelection].toString())
        for (world in masterWorlds) {
            if (world.locations.contains(masterLocations[editorSelection])) {
                val i = world.locations.indexOf(masterLocations[editorSelection])
                world.locations[i] = newL
                masterLocations[editorSelection] = newL
                println("With $newL")
            }
        }
    }

    fun editCreature(newCR: Creature) {
        println("Replaced " + masterCreatures[editorSelection].toString())
        for (world in masterWorlds) {
            for (location in world.locations) {
                if (location.creatures.contains(masterCreatures[editorSelection])) {
                    val i = location.creatures.indexOf(masterCreatures[editorSelection])
                    location.creatures[i] = newCR
                    masterCreatures[editorSelection] = newCR
                    println("With $newCR")
                }
            }
        }
    }

    fun editRace(newR: Race) {
        println("Replaced " + masterRaces[editorSelection].toString())
        for (world in masterWorlds) {
            for (location in world.locations) {
                if (location.races.contains(masterRaces[editorSelection])) {
                    val i = location.races.indexOf(masterRaces[editorSelection])
                    location.races[i] = newR
                    masterRaces[editorSelection] = newR
                    println("With $newR")
                }
            }
        }
    }

    fun editLandmark(newLA: Landmark) {
        println("Replaced " + masterLandmarks[editorSelection].toString())
        for (world in masterWorlds) {
            for (location in world.locations) {
                if (location.landmarks.contains(masterLandmarks[editorSelection])) {
                    val i = location.landmarks.indexOf(masterLandmarks[editorSelection])
                    location.landmarks[i] = newLA
                    masterLandmarks[editorSelection] = newLA
                    println("With $newLA")
                }
            }
        }
    }

    fun removeWorld(index: Int) {
        println("Removing world: " + masterWorlds[index])
        masterWorlds.removeAt(index)
        println("Done removing.")
    }

    fun removeCharacter(index: Int) {
        val c = masterCharacters[index]
        println("Removing location: $c")
        for (world in masterWorlds) {
            if (world.characters.contains((c))) {
                world.characters.remove(c)
            }
        }
        masterCharacters.remove(c)
        println("Done removing.")
    }

    fun removeLocation(index: Int) {
        val l = masterLocations[index]
        println("Removing location: $l")
        for (world in masterWorlds) {
            if (world.locations.contains((l))) {
                world.locations.remove(l)
            }
        }
        masterLocations.remove(l)
        println("Done removing.")
    }

    fun removeCreature(index: Int) {
        val cr = masterCreatures[index]
        println("Removing creature: $cr")
        for (world in masterWorlds) {
            for (location in world.locations)
                if (location.creatures.contains((cr))) {
                    location.creatures.remove(cr)
                    println("Done removing.")
                }
        }
        masterCreatures.remove(cr)
    }

    fun removeRace(index: Int) {
        val r = masterRaces[index]
        println("Removing creature: $r")
        for (world in masterWorlds) {
            for (location in world.locations)
                if (location.races.contains((r))) {
                    location.races.remove(r)
                    println("Done removing.")
                }
        }
        masterRaces.remove(r)
    }

    fun removeLandmark(index: Int) {
        val la = masterLandmarks[index]
        println("Removing landmark: $la")
        for (world in masterWorlds) {
            for (location in world.locations)
                if (location.landmarks.contains((la))) {
                    location.landmarks.remove(la)
                    println("Done removing.")
                }
        }
        masterLandmarks.remove(la)
    }

    fun createLocation(name: String, bio: String, w: World) {
        val l = Location(name, bio, w.name)
        masterLocations.add(l)
        if (masterWorlds.contains(w)) {
            w.locations.add(l)
            println("Locations Count: " + masterLocations.size)
        }
    }

    fun createCharacter(name: String, race: Race, world: World, bio: String) {
        val c = Character(name, race, bio, world.name)
        masterCharacters.add(c)
        if (masterWorlds.contains(world)) {
            world.characters.add(c)
        }
        println("Characters Count: " + masterCharacters.size)
    }

    fun createCreature(name: String, home: Location, bio: String) {
        val cr = Creature(name, bio, home.name)
        masterCreatures.add(cr)
        if (masterLocations.contains(home)) {
            home.addCreature(cr)
        }
        println("Creatures Count: " + masterCreatures.size)
    }

    fun createRace(name: String, home: Location, bio: String) {
        val r = Race(name, bio, home.name)
        masterRaces.add(r)
        if (masterLocations.contains(home)) {
            home.races.add(r)
        }
        println("Races Count: " + masterRaces.size)
    }

    fun createLandmark(name: String, bio: String, population: Int, loc: Location) {
        val la = Landmark(name, bio, loc.name, population)
        masterLandmarks.add(la)
        if (masterLocations.contains(loc)) {
            loc.addLandmark(la)
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

    fun getCharactersAsObservable(): ObservableList<Character> {
        return masterCharacters.asObservable()
    }

    fun getCreaturesAsObservable(): ObservableList<Creature> {
        return masterCreatures.asObservable()
    }

    fun getLandmarksAsObservable(): ObservableList<Landmark> {
        return masterLandmarks.asObservable()
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

    fun saveToJSON() {
        println("Writing to database...")
        val writer = FileWriter("ApocryphaDatabase.json")
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()
        gson.toJson(masterWorlds, writer)
        writer.flush()
        writer.close()
        println("Data successfully stored.")
    }

    fun readFromJSON() {
        try {
            println("Loading from database...")
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

            println("Data successfully loaded.")
            println("   Worlds loaded: " + masterWorlds.size)
            println("   Locations loaded: " + masterLocations.size)
            println("   Characters loaded: " + masterCharacters.size)
            println("   Races loaded: " + masterRaces.size)
            println("   Creatures loaded: " + masterCreatures.size)
            println("   Landmarks loaded: " + masterLandmarks.size)
        } catch (e: Exception) {
            println("Couldn't load from database, making new one...")
            saveToJSON()
            readFromJSON()
        }
    }
}