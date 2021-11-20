package com.racoon.waby.domain.usecases.authuser

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.racoon.waby.data.repository.UserRepository

class AuthUserUseCaseImpl(private val userRepository: UserRepository) : AuthUserUseCase{

    override fun firebaseDefaultAuthRegister(email: String, passwd: String) {
        println("estoy en el caso de uso")
        return userRepository.registerDefault(email,passwd)
    }

    override fun firebaseDefaultAuthSignIn(email: String, passwd: String) {
        return userRepository.logInDefault(email,passwd)
    }

    override fun getFirebaseUserMutableLiveData(): MutableLiveData<FirebaseUser> {
        return userRepository.getFirebaseUserMutableLiveData()
    }

    override fun getUserLoggedMutableLiveData(): MutableLiveData<Boolean> {
        return userRepository.getUserLoggedMutableLiveData()
    }


}