package com.racoon.waby.domain.usecases.authuser

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser

interface AuthUserUseCase {

    fun firebaseDefaultAuthRegister(email: String, passwd: String)
    fun firebaseDefaultAuthSignIn(email: String, passwd: String)

    fun getFirebaseUserMutableLiveData() : MutableLiveData<FirebaseUser>
    fun getUserLoggedMutableLiveData() : MutableLiveData<Boolean>

}