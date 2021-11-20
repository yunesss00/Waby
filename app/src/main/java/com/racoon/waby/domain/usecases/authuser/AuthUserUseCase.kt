package com.racoon.waby.domain.usecases.authuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.racoon.waby.common.SingleLiveEvent

interface AuthUserUseCase {

    fun firebaseDefaultAuthRegister(email: String, passwd: String)
    fun firebaseDefaultAuthSignIn(email: String, passwd: String)

    fun getFirebaseUserMutableLiveData() : SingleLiveEvent<FirebaseUser>
    fun getUserLoggedMutableLiveData() : MutableLiveData<Boolean>

}