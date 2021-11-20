package com.racoon.waby.data.repository

import androidx.annotation.IntegerRes
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.racoon.waby.common.SingleLiveEvent

interface UserRepository {

    fun signUpDefault(email: String, passwd: String, repeatedPasswd: String)
    fun signInDefault(email: String, passwd: String)

    fun getErrorLiveData() : SingleLiveEvent<Int>
    fun getStateLiveData() : SingleLiveEvent<Boolean>
}