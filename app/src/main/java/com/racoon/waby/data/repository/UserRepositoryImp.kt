package com.racoon.waby.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.racoon.waby.data.model.User
import com.racoon.waby.vo.Resource
import java.lang.Exception

class UserRepositoryImp : UserRepository {
    override fun setUserFirebase(user: User): Resource<User>  {

        println("creo el user")
        val email = user.email!!
        val passwd = user.passwd!!

        try {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, passwd)
            Resource.Success(user)
        } catch (e:Exception) {
            Resource.Failure(e)
        }

        return Resource.Success(user)


    }

    /*override fun returnSuccess(user: User): Resource<User> {
        return Resource.Success(user)
    }*/


}

