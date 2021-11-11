package com.racoon.waby.data.model

data class Group(val idGroup: String,
                 val groupCreator: String,
                 val icon: String,
                 var capacity: Int,
                 val participants: ArrayList<User>
)