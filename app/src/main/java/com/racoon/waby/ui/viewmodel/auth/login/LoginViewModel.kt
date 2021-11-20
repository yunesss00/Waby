package com.racoon.waby.ui.viewmodel.auth.login

import androidx.annotation.IntegerRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.racoon.waby.R
import com.racoon.waby.common.SingleLiveEvent
import com.racoon.waby.domain.usecases.authuser.AuthUserUseCase

class LoginViewModel(private val authUserUseCase: AuthUserUseCase) : ViewModel() {

    private val signUpSLE = SingleLiveEvent<Unit>()
    private val errorSLE = SingleLiveEvent<@IntegerRes Int>()
    private val successSLE = SingleLiveEvent<@IntegerRes Int>()
    val errorLD: LiveData<Int> = errorSLE
    val successLD: LiveData<Int> = successSLE
    val signUpLD: LiveData<Unit> = signUpSLE

    fun onSignUpPressed() {
        signUpSLE.call()
    }

    fun login(email: String, passwd: String) {
        /*if (email.isEmpty()) {
            errorSLE.value = R.string.login_error_email
            return
        }
        if (passwd.isEmpty()) {
            errorSLE.value = R.string.login_error_passwd
            return
        }*/

        authUserUseCase.firebaseDefaultAuthSignIn("prueba@prueba.com", "prueba")
        authUserUseCase.getState()
        authUserUseCase.getError()
    }

}

