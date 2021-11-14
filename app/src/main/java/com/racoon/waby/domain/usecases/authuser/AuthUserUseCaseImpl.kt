package com.racoon.waby.domain.usecases.authuser

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.racoon.waby.data.model.User

class AuthUserUseCaseImpl : AuthUserUseCase{

    override suspend fun firebaseDefaultAuth(user: User) {
        val email = user.email!!
        val passwd = user.passwd!!
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, passwd)



    }



}