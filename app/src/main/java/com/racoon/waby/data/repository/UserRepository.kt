package com.racoon.waby.data.repository

import com.racoon.waby.data.model.User
import com.racoon.waby.vo.Resource

interface UserRepository {
    fun setUserFirebase(user: User): Resource<User>
    //fun returnSuccess(user: User): Resource<User>
}