package com.racoon.waby.data.model

data class Badge (val idBadge: String,
                  val name: String
)

enum class BadgeName {
    COPAS,
    DISCOTECA,
    BIBLIOTECA,
    CHILLOUT
}