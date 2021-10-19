package com.apocrypha.adt

class Location constructor(var name: String, var bio: String) {
    var landmarks = ArrayList<Landmark>()
    var creatures = ArrayList<Creature>()
    var races = ArrayList<Race>()
    private var population: Int = 0

    init {
        calculatePop()
    }

    private fun calculatePop() {
        //sum all landmark populations
        for (landmark in landmarks) {
            population += landmark.population
        }
    }

    fun addLandmark(l: Landmark) {
        landmarks.add(l)
    }

    fun addCreature(cr: Creature) {
        creatures.add(cr)
    }

    fun getPop(): Int { return population }

    override fun toString(): String {
        return "Location: $name"
    }
}