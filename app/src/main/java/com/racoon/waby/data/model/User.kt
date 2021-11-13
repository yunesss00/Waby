package com.racoon.waby.data.model

import java.util.Date


data class User (val idUser: String = "",
                 val name: String = "",
                 val surname: String = "",
                 val userName: String = "",
                 val birthdate: Date,
                 val email:String = "",
                 val gender: Gender,
                 val phoneNumber: String = "",
                 val description: String = "",
                 val tags: ArrayList<Tag>,
                 val groupList: ArrayList<Group>,
                 val images: ArrayList<Image>
)

enum class Gender {
    MEN,
    WOMEN,
    NONBINARY
}