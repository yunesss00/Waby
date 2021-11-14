package com.racoon.waby.domain.usecases.authuser

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.racoon.waby.data.model.User

interface AuthUserUseCase {

    suspend fun firebaseDefaultAuth(user: User)
}