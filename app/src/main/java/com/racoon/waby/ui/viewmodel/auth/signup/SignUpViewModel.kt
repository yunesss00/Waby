package com.racoon.waby.ui.viewmodel.auth.signup

import androidx.annotation.IntegerRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.racoon.waby.R
import com.racoon.waby.common.SingleLiveEvent
import com.racoon.waby.domain.usecases.authuser.AuthUserUseCase

class SignUpViewModel(private val authUserUseCase: AuthUserUseCase) : ViewModel(){

    private val errorSLE = SingleLiveEvent<@IntegerRes Int>()
    private val successSLE = SingleLiveEvent<Boolean>()
    val errorLD: LiveData<Int> = errorSLE
    val successLD: LiveData<Boolean> = successSLE

    fun create(email: String, passwd: String, repeteadPasswd: String) {
        if (email.isEmpty()) {
            errorSLE.value = R.string.signup_error_email
        return
        }
        if (passwd.isEmpty() || repeteadPasswd.isEmpty()) {
            errorSLE.value = R.string.signup_error_password
            return
        }
        if (passwd != repeteadPasswd) {
            errorSLE.value = R.string.signup_error_password_notequals
            return
        }

        authUserUseCase.firebaseDefaultAuthSignUp(email,passwd,repeteadPasswd)
        authUserUseCase.getError()
        authUserUseCase.getState()

    }
}