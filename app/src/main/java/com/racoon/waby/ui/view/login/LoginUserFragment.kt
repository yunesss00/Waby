package com.racoon.waby.ui.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.racoon.waby.R
import com.racoon.waby.data.repository.UserRepositoryImp
import com.racoon.waby.databinding.FragmentLoginUserBinding
import com.racoon.waby.domain.usecases.authuser.AuthUserUseCaseImpl
import com.racoon.waby.ui.viewmodel.auth.AuthUserViewModel
import com.racoon.waby.ui.viewmodel.auth.VMFactory


class LoginUserFragment : Fragment() {



    //ViewBiding
    private  var _binding:FragmentLoginUserBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    //inicializamos el viewModel
    private val  authUserViewModel by viewModels<AuthUserViewModel> {
        VMFactory(AuthUserUseCaseImpl(UserRepositoryImp()))
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginUserBinding.inflate(inflater,container,false)




        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.adminUserButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginUserFragment_to_loginAdminUserFragment)
        }

        binding.registerButton.setOnClickListener {
            registerAuthDefault()
            //checkUserRegistered()
            //setupAuthViewModel()
        }

        binding.signInButton.setOnClickListener {
            signInAuthDefault()
            checkUserRegistered()

            //setupSignInAuthViewModel()
        }

    }


    private fun checkUserRegistered() {
        println("estoy en el check")
        //authUserViewModel.oncreate()
        authUserViewModel.getUserData().observe(viewLifecycleOwner) { firebaseUser ->
            val email = firebaseUser?.email
            println("En el check email:")
            println(email)
            if (firebaseUser != null) {
                findNavController().navigate(R.id.action_loginUserFragment_to_registerUserFragment)
            } else {
                Toast.makeText(context,"No se ha podido registrar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signInAuthDefault() {
        val email = binding.emailEditText.text.toString()
        val passwd = binding.passwordEditText.text.toString()
        if (email.isNotBlank() && passwd.isNotBlank()) {
            authUserViewModel.signInAuthDefault(email,passwd)
        }else{
            Toast.makeText(context, "Uno o ambos campos están vacíos", Toast.LENGTH_SHORT).show()
        }
    }

    //recogemos los datos del user y los pasamos al viewModel
    private fun registerAuthDefault () {

        val email = binding.emailEditText.text.toString()
        val passwd = binding.passwordEditText.text.toString()
        if (email.isNotEmpty() && passwd.isNotEmpty()) {

            authUserViewModel.registerAuthDefault(email,passwd)
        }else{
            Toast.makeText(context, "Uno o ambos campos están vacíos", Toast.LENGTH_SHORT).show()
        }
    }

    /*private fun setupAuthViewModel() {
        authUserViewModel.registerAuthLD.observe(viewLifecycleOwner) { success->
            if (success) {
                findNavController().navigate(R.id.action_loginUserFragment_to_registerUserFragment)
            }else{
                view?.also {
                    Snackbar.make(it, "El usuario o contraseña no es correcto", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }*/

   /* private fun setupSignInAuthViewModel() {
        authUserViewModel.signInAuthLD.observe(viewLifecycleOwner) { success->
            if (success) {
                findNavController().navigate(R.id.action_loginUserFragment_to_registerUserFragment)
            }else{
                view?.also {
                    Snackbar.make(it, "El usuario o contraseña no es correcto", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }*/




}