package com.racoon.waby.domain.usecases.authuser

import com.racoon.waby.data.model.User
import com.racoon.waby.data.repository.UserRepository
import com.racoon.waby.vo.Resource

class AuthUserUseCaseImpl(private val userRepository: UserRepository) : AuthUserUseCase{



    override fun firebaseDefaultAuth(user: User): Resource<User> {
        println("estoy en el caso de uso")
        return userRepository.setUserFirebase(user)
    }



}