package com.apocrypha.adt

class Character constructor(
    var name: String = "",
    var race: Race,
    var bio: String = "",
) {
    override fun toString(): String {
        return "Character: $name"
    }
}