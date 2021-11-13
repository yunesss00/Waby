package com.racoon.waby.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.racoon.waby.R
import com.racoon.waby.databinding.ActivityMainBinding
import com.racoon.waby.ui.viewmodel.LoginUserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val loginUserViewModel: LoginUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginUserViewModel.onCreate()



        //from loginUserFragment
        /*supportFragmentManager
            .setFragmentResultListener(
                "request_key",this) { requestKey, bundle ->
                val email = bundle.getString("bundle_key")
                authentication(email)
            }*/

    }


}

