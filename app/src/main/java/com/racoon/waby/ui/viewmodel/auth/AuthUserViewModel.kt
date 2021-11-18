package com.racoon.waby.ui.viewmodel.auth

import android.app.Application
import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseUser
import com.racoon.waby.domain.usecases.authuser.AuthUserUseCase


class AuthUserViewModel(private val authUserUseCase: AuthUserUseCase) : ViewModel(){

    private var userData = MutableLiveData<FirebaseUser?>()
    private var loggedStatus = MutableLiveData<Boolean>()

    fun oncreate() {

        userData = authUserUseCase.getFirebaseUserMutableLiveData()
        loggedStatus = authUserUseCase.getUserLoggedMutableLiveData()
    }

    fun getUserData() : MutableLiveData<FirebaseUser?> {
        return userData
    }

    fun getLoggedStatus() : MutableLiveData<Boolean> {
        return loggedStatus
    }

    fun registerAuthDefault (email: String, passwd: String) {
        authUserUseCase.firebaseDefaultAuthRegister(email,passwd)
    }



    fun signInAuthDefault(email: String,passwd: String) {
        authUserUseCase.firebaseDefaultAuthSignIn(email,passwd)
    }

    fun logOut() {
        //todo
    }








    //private val authUserUseCase = AuthUserUseCaseImpl()
    //var view: AuthContract.authView? = null

    /*fun registerDefault(user: User) {

        println("estoy en el viewmodel")
        val fetchUserAuth = liveData() {
            emit(Resource.Loading())
            try {
                println("estoy en el try")
                emit(authUserUseCase.firebaseDefaultAuth(user))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }

    }*/


/*
    private val registerAuthSLE = SingleLiveEvent<Boolean>()
    private val signInAuthSLE = SingleLiveEvent<Boolean>()
    val registerAuthLD: LiveData<Boolean> = registerAuthSLE
    val signInAuthLD: LiveData<Boolean> = signInAuthSLE
    //val selectedUser: LiveData<User> get() = user



    fun registerAuthDefault (user: User) {


        if (authUserUseCase.firebaseDefaultAuthRegister(user)) {
            println("se a registrao")
            registerAuthSLE.value = true
        }else {
            println("no se ha registrado")
        }
    }

    fun signInAuthDefault (email: String, passwd: String) {

        if (authUserUseCase.firebaseDefaultAuthSignIn(email,passwd)) {
            registerAuthSLE.value = true
        }
    }*/

    /*fun onCreate() {
        val user = selectedUser.value!!
        viewModelScope.launch {
            val result = loginDefaultUserUseCase (user)

            if (!result.isNullOrEmpty()) {
                showNext(result)
            }
        }
    }*/

}