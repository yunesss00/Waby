package com.racoon.waby.data.model


data class Tag (val idTag: String,
                val name: String
)

enum class TagName {
    GAMER,
    FUTBOL,
    CANTAR,
    MUSICA,
    BAILAR,
    NATURALEZA,
    NETFLIX

}
