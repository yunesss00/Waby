package com.racoon.waby.ui.view.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.racoon.waby.R
import com.racoon.waby.databinding.FragmentSplashBinding
import com.racoon.waby.ui.viewmodel.auth.splash.SplashViewModel

class SplashFragment : Fragment() {

    private val viewModel by viewModels<SplashViewModel>()
    //ViewBiding
    private  var _binding: FragmentSplashBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.finishLD.observe(viewLifecycleOwner) { isUserLogged->
            if (isUserLogged) {
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_registerUserFragment)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.resume()
    }

}