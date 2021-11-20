package com.racoon.waby.data.repository

import androidx.annotation.IntegerRes
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.racoon.waby.R
import com.racoon.waby.common.SingleLiveEvent


class UserRepositoryImp : UserRepository {

    private var error = SingleLiveEvent<@IntegerRes Int>()
    private var successSignUp = SingleLiveEvent<Boolean>()
    private var successSignIn = SingleLiveEvent<Int>()
    private var taskCompleted = false



    override fun signUpDefault(email: String, passwd: String, repeatedPasswd: String) {
        println("creando")

        Firebase.auth.createUserWithEmailAndPassword(email,passwd).addOnCompleteListener {authResult->
            if (taskCompleted) return@addOnCompleteListener
            taskCompleted = true

            val newUser = Firebase.auth.currentUser
            if (authResult.isSuccessful && newUser != null) {
                /*newUser.sendEmailVerification().addOnCompleteListener { emailTask->

                }
                Firebase.auth.signOut()*/
                successSignUp.postValue(authResult.isSuccessful)
            }else {
                println("No se ha podido registrar")
                error.value = R.string.signup_error


            }
        }
    }

    override fun signInDefault(email: String, passwd: String) {

        println("inicio sesion")

        Firebase.auth.signInWithEmailAndPassword(email,passwd).addOnCompleteListener { authResult->
            if (authResult.isSuccessful) {
                val user = Firebase.auth.currentUser
                if (user != null && user.isEmailVerified) {
                    successSignIn.value = R.string.login_success
                }else {
                    error.value = R.string.login_email
                }


            }else {
                error.value = R.string.login_error
                println("No se ha podido loggear")
            }
        }
    }

    override fun getErrorLiveData(): SingleLiveEvent<Int> {
        return error
    }

    override fun getStateLiveData(): SingleLiveEvent<Boolean> {
        return successSignUp
    }
}

