package com.racoon.waby.ui.viewmodel.auth

import com.racoon.waby.data.model.User

interface AuthContract {

    fun showError(msgError: String?)
    fun navegateToRegister(user: User)
}