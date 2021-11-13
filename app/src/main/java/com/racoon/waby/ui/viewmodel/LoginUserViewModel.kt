package com.racoon.waby.ui.viewmodel

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.racoon.waby.data.model.User
import com.racoon.waby.domain.usecases.loginuser.LoginDefaultUserUseCase
import com.racoon.waby.ui.view.AuxiliarActivity
import kotlinx.coroutines.launch

class LoginUserViewModel : ViewModel() {

    val loginDefaultUserUseCase = LoginDefaultUserUseCase()

    val mutableSelectedUser = MutableLiveData<User>()
    val selectedUser: LiveData<User> get() = mutableSelectedUser

    fun selectUser (user: User) {
        mutableSelectedUser.value = user
    }

    fun onCreate(context: packageContext) {
        val user = selectedUser.value!!
        viewModelScope.launch {
            val result = loginDefaultUserUseCase (user)

            if (!result.isNullOrEmpty()) {
                showNext(result)
            }
        }
    }

    private fun showNext(result: String) {
        val auxiliarIntent = Intent()
        startActivity(auxiliarIntent)
    }

}