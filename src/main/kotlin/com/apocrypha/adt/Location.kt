package com.apocrypha.adt

class Location constructor(var name: String, var bio: String) {
    var landmarks = ArrayList<Landmark>()
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

    fun getPop(): Int { return population }
}