package com.racoon.waby.ui.viewmodel.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.google.firebase.auth.FirebaseUser
import com.racoon.waby.common.Resource
import com.racoon.waby.common.SingleLiveEvent
import com.racoon.waby.domain.usecases.authuser.AuthUserUseCase
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class LoginViewModel(private val authUserUseCase: AuthUserUseCase) : ViewModel() {


    fun login(email: String, passwd: String): LiveData<Resource<FirebaseUser?>> {


        val fetchFirebaseUser = liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {

                emit(authUserUseCase.firebaseDefaultAuthSignIn(email,passwd))

            }catch (e: Exception) {
                emit(Resource.Failure(e))
            }

        }

        return fetchFirebaseUser
    }

}

