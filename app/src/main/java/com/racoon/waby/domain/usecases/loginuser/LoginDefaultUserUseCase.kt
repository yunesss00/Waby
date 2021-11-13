package com.racoon.waby.domain.usecases.loginuser

import com.google.firebase.auth.FirebaseAuth
import com.racoon.waby.data.model.User
import com.racoon.waby.data.repository.UserRepository

class LoginDefaultUserUseCase {
    private val userRepository = UserRepository()

    operator fun invoke(user: User) = userRepository.firebaseAuth(user)



}