package com.racoon.waby.ui.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.racoon.waby.domain.usecases.authuser.AuthUserUseCase

class VMFactory(private val authUserUseCase: AuthUserUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AuthUserUseCase::class.java).newInstance(authUserUseCase)
    }

}