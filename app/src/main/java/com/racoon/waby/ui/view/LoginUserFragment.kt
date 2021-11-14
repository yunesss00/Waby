package com.racoon.waby.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.racoon.waby.R
import com.racoon.waby.data.model.User
import com.racoon.waby.databinding.FragmentLoginUserBinding
import com.racoon.waby.ui.viewmodel.auth.AuthContract
import com.racoon.waby.ui.viewmodel.auth.AuthUserViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "email"
private const val ARG_PARAM2 = "passwd"

class LoginUserFragment : Fragment() ,AuthContract {

    //ViewBiding
    private  var _binding:FragmentLoginUserBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val authUserViewModel: AuthUserViewModel by activityViewModels()


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
            val toast = Toast.makeText(context, "Uno o ambos campos están vacíos", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showError(msgError: String?) {
        Toast.makeText(context,msgError,Toast.LENGTH_LONG).show()
    }

    override fun navegateToRegister(user: User) {
        
    }


}