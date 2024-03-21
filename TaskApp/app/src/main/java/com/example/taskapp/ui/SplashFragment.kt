package com.example.taskapp.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ao inves de vc apenas chamar a função fazendo checkAuth(), vc vai char ela depois de 3 segundos
        Handler(Looper.getMainLooper()).postDelayed(this::checkAuth, 3000)
    }

    private fun checkAuth(){
        //vai levar para outra tela fragment
        findNavController().navigate(R.id.action_splashFragment_to_authentication)//é o id da setinha que la no main_graph
        // aponta do splash para o authentication
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}