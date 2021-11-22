package com.racoon.waby.domain.usecases.authuser

import com.google.firebase.auth.FirebaseUser
import com.racoon.waby.common.Resource
import com.racoon.waby.common.SingleLiveEvent
import com.racoon.waby.data.repository.UserRepository

class AuthUserUseCaseImpl(private val userRepository: UserRepository) : AuthUserUseCase{

    override fun firebaseDefaultAuthSignUp(email: String, passwd: String, repeatedPasswd: String) : Resource<FirebaseUser?>? {
        return userRepository.signUpDefault(email,passwd,repeatedPasswd)
    }

    override fun firebaseDefaultAuthSignIn(email: String, passwd: String) : Resource<FirebaseUser?>{
        return userRepository.signInDefault(email,passwd)
    }

}