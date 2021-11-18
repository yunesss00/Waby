package com.racoon.waby.data.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser



class UserRepositoryImp : UserRepository {

    private var auth: FirebaseAuth
    private var firebaseUserMutableLiveData = MutableLiveData<FirebaseUser?>()
    private var userLoggedMutableLiveData = MutableLiveData<Boolean>()

    init {
        auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            firebaseUserMutableLiveData.postValue(auth.currentUser)
        } else {
            firebaseUserMutableLiveData.postValue(null)
        }
    }


    override fun registerDefault(email: String, passwd: String) {


        println("creando")

        auth.createUserWithEmailAndPassword(email,passwd).addOnCompleteListener {
            if (it.isSuccessful) {
                firebaseUserMutableLiveData.postValue(auth.currentUser)
            }else {
                firebaseUserMutableLiveData.postValue(null)
                println("No se ha podido registrar")
            }
        }
    }

    override fun logInDefault(email: String, passwd: String) {
        println("inicio sesion")

        auth.signInWithEmailAndPassword(email,passwd).addOnCompleteListener {
            if (it.isSuccessful) {
                firebaseUserMutableLiveData.postValue(auth.currentUser)

            }else {
                firebaseUserMutableLiveData.postValue(null)
                println("No se ha podido loggear")
            }
        }
    }

    override fun getFirebaseUserMutableLiveData(): MutableLiveData<FirebaseUser?> {
        return firebaseUserMutableLiveData
    }

    override fun getUserLoggedMutableLiveData(): MutableLiveData<Boolean> {
        return userLoggedMutableLiveData
    }
}

