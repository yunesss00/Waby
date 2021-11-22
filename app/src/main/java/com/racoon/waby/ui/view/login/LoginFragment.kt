package com.racoon.waby.ui.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.racoon.waby.R
import com.racoon.waby.common.Resource
import com.racoon.waby.data.repository.UserRepositoryImp
import com.racoon.waby.databinding.FragmentLoginBinding
import com.racoon.waby.domain.usecases.authuser.AuthUserUseCaseImpl
import com.racoon.waby.ui.viewmodel.auth.login.LoginVMFactory
import com.racoon.waby.ui.viewmodel.auth.login.LoginViewModel

class LoginFragment : Fragment() {

    //private val viewModel by viewModels<LoginViewModel>()
    private val  viewModel by viewModels<LoginViewModel> {
        LoginVMFactory(AuthUserUseCaseImpl(UserRepositoryImp()))
    }
    //ViewBiding
    private  var _binding: FragmentLoginBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUp()
    }

    private fun setUp() {

        binding.registerButton.setOnClickListener {
            openSignUp()
        }

        binding.signInButton.setOnClickListener {
            val email = binding.emailEditText2.text.toString()
            val passwd = binding.passwordEditText2.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(context,R.string.login_error_email,Toast.LENGTH_SHORT).show()
            }
            if (passwd.isEmpty()) {
                Toast.makeText(context,R.string.login_error_passwd,Toast.LENGTH_SHORT).show()
            }else {
                viewModel.login(email,passwd).observe(viewLifecycleOwner, Observer {
                    when (it) {
                        is Resource.Loading -> {
                            //todo
                        }
                        is Resource.Result -> {
                            openAux()
                        }
                        is Resource.Failure -> {
                            Toast.makeText(context,R.string.login_failed,Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }
        }
    }

    private fun openAux() {
        findNavController().navigate(R.id.action_loginFragment_to_registerUserFragment)
    }

    private fun openSignUp() {
        findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
    }


}