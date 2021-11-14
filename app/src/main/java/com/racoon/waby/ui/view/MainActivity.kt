package com.racoon.waby.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import com.racoon.waby.databinding.ActivityMainBinding
import com.racoon.waby.ui.viewmodel.auth.AuthUserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val authUserViewModel: AuthUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        //from loginUserFragment
        /*supportFragmentManager
            .setFragmentResultListener(
                "request_key",this) { requestKey, bundle ->
                val email = bundle.getString("bundle_key")
                authentication(email)
            }*/

    }


}

