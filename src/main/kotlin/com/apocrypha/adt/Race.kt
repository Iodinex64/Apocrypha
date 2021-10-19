package com.apocrypha.adt

class Race constructor(
    var name: String = "",
    var bio: String = ""
) {
    override fun toString(): String {
        return "Race: $name"
    }
}