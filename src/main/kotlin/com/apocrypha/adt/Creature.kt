package com.apocrypha.adt

class Creature constructor(
    var name: String = "",
    var bio: String = "",
    var locationName: String = ""
) {
    override fun toString(): String {
        return "Creature: $name"
    }
}