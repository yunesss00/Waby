package com.racoon.waby.ui.viewmodel.auth.splash

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.racoon.waby.common.SingleLiveEvent

class SplashViewModel() : ViewModel() {

    private val finishSLE = SingleLiveEvent<Boolean>()
    val finishLD: LiveData<Boolean> = finishSLE
    fun resume() {
        Looper.myLooper()?.also {
            Handler(it).postDelayed({
                finishSLE.value = (Firebase.auth.currentUser!=null)
            },2000)
        }
    }
}