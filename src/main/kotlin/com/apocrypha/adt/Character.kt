package com.apocrypha.adt

class Character constructor(
    var name: String = "",
    var race: Race,
    var bio: String = "",
    var worldName: String = ""
) {
    override fun toString(): String {
        return "Character: $name ($race | Bio: $bio | World Name: $worldName)"
    }
}