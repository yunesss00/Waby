package com.racoon.waby.ui.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.racoon.waby.data.model.User
import com.racoon.waby.domain.usecases.authuser.AuthUserUseCaseImpl
import com.racoon.waby.ui.view.MainActivity
import kotlinx.coroutines.launch

class AuthUserViewModel : ViewModel() ,AuthContract{

    private val authUserUseCase = AuthUserUseCaseImpl()
    var view: AuthContract.authView? = null

    fun registerDefault(user: User) {

        viewModelScope.launch {
            try {
                authUserUseCase.firebaseDefaultAuth(user)
                view?.a()
                view?.navigateToRegister(user)

            }catch (e:AuthExeptions) {
                view?.showError(e.message)
            }
        }
    }







    /*

    val mutableSelectedUser = MutableLiveData<User>()
    val selectedUser: LiveData<User> get() = mutableSelectedUser

    fun selectUser (user: User) {
        mutableSelectedUser.value = user
    }


    fun loginUser(user: User) {
        selectUser (loginDefaultUserUseCase.firebaseAuth())
    }

    //LiveData que será observado por la view
    fun getSelectedUserLiveData() : LiveData<User> {
        return mutableSelectedUser
    }*/

    /*fun onCreate() {
        val user = selectedUser.value!!
        viewModelScope.launch {
            val result = loginDefaultUserUseCase (user)

            if (!result.isNullOrEmpty()) {
                showNext(result)
            }
        }
    }*/

    /*private fun showNext(result: String) {
        val auxiliarIntent = Intent()
        startActivity(auxiliarIntent)
    }*/

}