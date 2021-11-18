package com.racoon.waby.ui.view.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.racoon.waby.databinding.FragmentLoginUserBinding
import com.racoon.waby.databinding.FragmentRegisterUserBinding

class RegisterUserNameFragment : Fragment() {

    //ViewBiding
    private  var _binding: FragmentRegisterUserBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterUserBinding.inflate(inflater,container,false)
        return binding.root
    }


}