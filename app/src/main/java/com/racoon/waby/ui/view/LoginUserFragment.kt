package com.racoon.waby.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.racoon.waby.R
import com.racoon.waby.data.model.User
import com.racoon.waby.databinding.FragmentLoginUserBinding
import com.racoon.waby.ui.viewmodel.auth.AuthUserViewModel


class LoginUserFragment : Fragment() {


    //ViewBiding
    private  var _binding:FragmentLoginUserBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val authUserViewModel: AuthUserViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        //val user = User(email = email,passwd = passwd)
        binding.registerButton.setOnClickListener {
            registerDefault()
            findNavController().navigate(R.id.action_loginUserFragment_to_registerUserFragment)
        }
    }

    //recogemos los datos del user y los pasamos al viewModel
    private fun registerDefault () {
        val email = binding.emailEditText.text.toString()
        val passwd = binding.passwordEditText.text.toString()
        if (email.isNotBlank() && passwd.isNotBlank()) {
            val user = User(email = email, passwd = passwd)
            authUserViewModel.registerDefault(user)
        }else{
            Toast.makeText(context, "Uno o ambos campos están vacíos", Toast.LENGTH_SHORT).show()
        }
    }




}