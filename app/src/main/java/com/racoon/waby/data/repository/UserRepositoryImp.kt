package com.racoon.waby.data.repository

import androidx.annotation.IntegerRes
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.racoon.waby.R
import com.racoon.waby.common.Resource
import com.racoon.waby.common.SingleLiveEvent


class UserRepositoryImp : UserRepository {

    override fun signUpDefault(email: String, passwd: String, repeatedPasswd: String) : Resource<FirebaseUser?>? {
        println("creando")

       /* Firebase.auth.createUserWithEmailAndPassword(email,passwd).addOnCompleteListener {authResult->
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
        }*/

        Firebase.auth.createUserWithEmailAndPassword(email,passwd)
        val user = Firebase.auth.currentUser
        return if (user != null) {
            println(user.email)
            Resource.Result(user)
        } else {
            null
        }


    }



    override fun signInDefault(email: String, passwd: String) : Resource<FirebaseUser?>{

        println("inicio sesion")

        Firebase.auth.signInWithEmailAndPassword(email,passwd)
        val user = Firebase.auth.currentUser

        if (user != null) {
            println(user.email)
        }
        return Resource.Result(user)
    }

}

