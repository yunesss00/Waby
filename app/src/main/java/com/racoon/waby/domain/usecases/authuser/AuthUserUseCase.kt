package com.racoon.waby.domain.usecases.authuser

import com.racoon.waby.vo.Resource
import com.racoon.waby.data.model.User

interface AuthUserUseCase {

    fun firebaseDefaultAuth(user: User) : Resource<User>
}