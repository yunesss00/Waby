package com.racoon.waby.ui.view.signup

import android.app.Activity
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
import com.racoon.waby.databinding.FragmentSignUpBinding
import com.racoon.waby.domain.usecases.authuser.AuthUserUseCaseImpl
import com.racoon.waby.ui.viewmodel.auth.signup.SignUpVMFactory
import com.racoon.waby.ui.viewmodel.auth.signup.SignUpViewModel

class SignUpFragment : Fragment() {

    //private val viewModel by viewModels<SignUpViewModel>()
    private val  viewModel by viewModels<SignUpViewModel> {
        SignUpVMFactory(AuthUserUseCaseImpl(UserRepositoryImp()))
    }
    //ViewBiding
    private  var _binding: FragmentSignUpBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater,container,false)
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
        val passwdRepeat = binding.repeatPasswordEditText.text.toString()


        binding.registerButton.setOnClickListener {
            viewModel.create(email, passwd,passwdRepeat)
        }
    }

    private fun setUpViewModel() {
        with(viewModel) {
            successLD.observe(viewLifecycleOwner) {
                activity?.also {
                    Toast.makeText(context,R.string.signup_success,Toast.LENGTH_SHORT).show()
                }
                findNavController().navigateUp()
            }
            errorLD.observe(viewLifecycleOwner) {
                activity?.also {
                    Toast.makeText(context,R.string.signup_error,Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}