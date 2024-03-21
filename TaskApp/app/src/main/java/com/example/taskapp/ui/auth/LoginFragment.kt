package com.example.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()

    }

    private fun initListeners(){
        binding.btnRegister.setOnClickListener{
            //vai levar para outra tela fragment
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)//é o id da setinha que la no main_graph
            // so que dessa vez é a setinha que esta no sub graph
        }

        binding.btnRecover.setOnClickListener{
            //vai levar para outra tela fragment
            findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment)//é o id da setinha que la no main_graph
            // so que dessa vez é a setinha que esta no sub graph
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}