package com.racoon.waby.ui.viewmodel.auth.signup

import androidx.annotation.IntegerRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.google.firebase.auth.FirebaseUser
import com.racoon.waby.common.Resource
import com.racoon.waby.common.SingleLiveEvent
import com.racoon.waby.domain.usecases.authuser.AuthUserUseCase
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class SignUpViewModel(private val authUserUseCase: AuthUserUseCase) : ViewModel(){

    private var errorSLE = SingleLiveEvent<@IntegerRes Int>()
    private var successSLE = SingleLiveEvent<Boolean>()


    fun create(email: String, passwd: String, repeteadPasswd: String) : LiveData<Resource<FirebaseUser?>?> {

        val fetchFirebaseUser = liveData(Dispatchers.IO) {
            emit(Resource.Loading())



            try {
                emit(authUserUseCase.firebaseDefaultAuthSignUp(email,passwd,repeteadPasswd))
            }catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }

        return fetchFirebaseUser

    }
}