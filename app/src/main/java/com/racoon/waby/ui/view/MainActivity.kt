package com.racoon.waby.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.racoon.waby.R
import com.racoon.waby.databinding.ActivityMainBinding
import com.racoon.waby.ui.viewmodel.auth.AuthUserViewModel

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val authUserViewModel: AuthUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        //llama al metodo para volver al fragmet anterior
        NavigationUI.setupActionBarWithNavController(this,navController)

        //from loginUserFragment
        /*supportFragmentManager
            .setFragmentResultListener(
                "request_key",this) { requestKey, bundle ->
                val email = bundle.getString("bundle_key")
                authentication(email)
            }*/

    }
    //para volver al fragment anterior
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    fun showError(msgError: String?) {
        Toast.makeText(this,msgError, Toast.LENGTH_LONG).show()
    }





}

