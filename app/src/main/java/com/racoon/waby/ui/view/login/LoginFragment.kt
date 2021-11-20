package com.racoon.waby.ui.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.racoon.waby.R
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
        setUpViewModel()
    }

    private fun setUp() {
        val email = binding.emailEditText.text.toString()
        val passwd = binding.passwordEditText.text.toString()
        print(email)
        binding.registerButton.setOnClickListener {viewModel.onSignUpPressed()}
        binding.signInButton.setOnClickListener {
            viewModel.login(email,passwd)
        }
    }

    private fun setUpViewModel() {
        with(viewModel) {
            signUpLD.observe(viewLifecycleOwner) {
                openSignUp()
            }
            successLD.observe(viewLifecycleOwner) {
                activity?.also {
                    Toast.makeText(context,R.string.login_success,Toast.LENGTH_SHORT).show()
                }

                openAux()
            }
            errorLD.observe(viewLifecycleOwner) { msg->
                activity?.also {
                    Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
                }
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