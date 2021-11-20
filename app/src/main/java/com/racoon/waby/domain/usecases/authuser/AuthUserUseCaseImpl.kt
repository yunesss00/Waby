package com.racoon.waby.domain.usecases.authuser

import com.racoon.waby.common.SingleLiveEvent
import com.racoon.waby.data.repository.UserRepository

class AuthUserUseCaseImpl(private val userRepository: UserRepository) : AuthUserUseCase{

    override fun firebaseDefaultAuthSignUp(email: String, passwd: String, repeatedPasswd: String) {
        return userRepository.signUpDefault(email,passwd,repeatedPasswd)
    }

    override fun firebaseDefaultAuthSignIn(email: String, passwd: String) {
        return userRepository.signInDefault(email,passwd)
    }

    override fun getError(): SingleLiveEvent<Int> {
        return userRepository.getErrorLiveData()
    }

    override fun getState(): SingleLiveEvent<Boolean> {
        return userRepository.getStateLiveData()
    }


}