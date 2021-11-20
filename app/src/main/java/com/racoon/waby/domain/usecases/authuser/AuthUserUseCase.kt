package com.racoon.waby.domain.usecases.authuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.racoon.waby.common.SingleLiveEvent

interface AuthUserUseCase {

    fun firebaseDefaultAuthSignUp(email: String, passwd: String, repeatedPasswd: String)
    fun firebaseDefaultAuthSignIn(email: String, passwd: String)

    fun getError() : SingleLiveEvent<Int>
    fun getState() : SingleLiveEvent<Boolean>

}