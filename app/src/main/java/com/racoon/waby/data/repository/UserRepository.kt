package com.racoon.waby.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.racoon.waby.data.model.User

class UserRepository {


    fun firebaseAuth(user: User): String {
        val email = user.email!!
        val passwd = user.passwd!!
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, passwd)
           /* .addOnCompleteListener {
                if (it.isSuccessful) {
                    val email = it.result?.user?.email?:""

                } else {
                    println("No se ha podido autorizar el usuario")
                }
            }*/

        return email
    }

}

