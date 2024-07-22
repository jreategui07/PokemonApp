package com.example.pokemonapp

import kotlin.random.Random

class Pokemon {
    var name:String
    var type:String
    var description:String
    var imageUrl:String
    var attackPower:Int

    constructor(
        name: String,
        type: String,
        description: String,
        imageUrl: String
    ) {
        this.name = name
        this.type = type
        this.description = description
        this.imageUrl = imageUrl
        // randomly generated number between 30-100
        this.attackPower = Random.nextInt(30, 100)
    }

    override fun toString(): String {
        return "Pokemon(name='$name', type='$type', description='$description', imageUrl='$imageUrl', attackPower=$attackPower)"
    }
}