package com.racoon.waby.data.model

import java.util.Date


data class User (val idUser: String? = null,
                 val name: String? = null,
                 val surname: String? = null,
                 val userName: String? = null,
                 val birthdate: Date? = null,
                 val email:String? = null,
                 val passwd: String? = null,
                 val gender: Gender? = null,
                 val phoneNumber: String? = null,
                 val description: String? = null,
                 val tags: ArrayList<Tag>? = null,
                 val groupList: ArrayList<Group>? = null,
                 val images: ArrayList<Image>? = null
)

enum class Gender {
    MEN,
    WOMEN,
    NONBINARY
}