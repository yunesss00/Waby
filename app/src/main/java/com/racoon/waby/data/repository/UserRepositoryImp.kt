package com.racoon.waby.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.racoon.waby.common.SingleLiveEvent


class UserRepositoryImp : UserRepository {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseUserMutableLiveData = SingleLiveEvent<FirebaseUser>()
    private var userLoggedMutableLiveData = MutableLiveData<Boolean>()

    private fun start() {
        println("esty en el init")

        if (auth.currentUser != null) {
            firebaseUserMutableLiveData.postValue(auth.currentUser)
            val email = auth.currentUser!!.email
            println( email)
        } else {
            println("No hay user")
            //firebaseUserMutableLiveData.postValue(null)
        }
    }


    override fun registerDefault(email: String, passwd: String) {

        start()

        println("creando")

        auth.createUserWithEmailAndPassword(email,passwd).addOnCompleteListener {
            if (it.isSuccessful) {
                firebaseUserMutableLiveData.postValue(auth.currentUser)
            }else {
                //firebaseUserMutableLiveData.postValue(null)
                println("No se ha podido registrar")
            }
        }
    }

    override fun logInDefault(email: String, passwd: String) {

        start()

        println("inicio sesion")

        auth.signInWithEmailAndPassword(email,passwd).addOnCompleteListener {
            if (it.isSuccessful) {
                firebaseUserMutableLiveData.postValue(auth.currentUser)

            }else {
                println(auth.currentUser)
                //firebaseUserMutableLiveData.postValue(null)
                println("No se ha podido loggear")
            }
        }
    }

    override fun getFirebaseUserMutableLiveData(): SingleLiveEvent<FirebaseUser> {
        return firebaseUserMutableLiveData
    }

    override fun getUserLoggedMutableLiveData(): MutableLiveData<Boolean> {
        return userLoggedMutableLiveData
    }
}

