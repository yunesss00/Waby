package com.racoon.waby.domain.usecases.authuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.racoon.waby.common.Resource
import com.racoon.waby.common.SingleLiveEvent

interface AuthUserUseCase {

    fun firebaseDefaultAuthSignUp(email: String, passwd: String, repeatedPasswd: String) : Resource<FirebaseUser?>?
    fun firebaseDefaultAuthSignIn(email: String, passwd: String) : Resource<FirebaseUser?>

}