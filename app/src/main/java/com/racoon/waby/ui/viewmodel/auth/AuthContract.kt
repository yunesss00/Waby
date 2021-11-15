package com.racoon.waby.ui.viewmodel.auth

import com.racoon.waby.data.model.User

interface AuthContract {

   interface authView {
       fun showError(msgError: String?)
       fun navigateToRegister(user: User) {
           println("authcontact")
       }
       fun a () {
           println("a")
       }
   }
}