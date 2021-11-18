package com.racoon.waby.data.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.racoon.waby.data.model.User
import com.racoon.waby.vo.Resource

interface UserRepository {
    fun registerDefault(email: String, passwd: String)
    fun logInDefault(email: String, passwd: String)

    fun getFirebaseUserMutableLiveData() : MutableLiveData<FirebaseUser?>
    fun getUserLoggedMutableLiveData() : MutableLiveData<Boolean>
}