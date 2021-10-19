package com.apocrypha.adt

class Landmark constructor(
    var name: String = "",
    var bio: String = "",
    var population: Int = 0
) {
    override fun toString(): String {
        return "Landmark: $name"
    }
}