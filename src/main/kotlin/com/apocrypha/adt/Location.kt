package com.apocrypha.adt

import com.apocrypha.Landmark

class Location constructor(
    var name: String = "",
    var landmarks: MutableList<Landmark>?,
    private var population: Int = 0,
    var bio: String = ""
) {
    init {
        //sum all landmark populations
        for (landmark in landmarks!!) {
            population += landmark.population
        }
    }

    fun getPop(): Int { return population }
}