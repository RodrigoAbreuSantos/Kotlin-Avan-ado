package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.fragment.databinding.FragmentABinding

class Fragment_A : Fragment() {

    private var _binding: FragmentABinding? = null//configurando viewBinding nos fragments
    private val binding get() = _binding!!//configurando viewBinding nos fragments

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //configurando viewBinding nos fragments
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()

        listenerFragment()

    }

    private fun initListeners(){
        val name = "Aley Santana"
        binding.btnNext.setOnClickListener {
            val action = Fragment_ADirections.actionFragmentAToFragmentB(name) //esta passando a informação para o fragment b,
            // agora o fragment b precisa receber essa informação
            findNavController().navigate(action) //esta indo de um fragment para outro
        }
    }

    private fun listenerFragment(){
        parentFragmentManager.setFragmentResultListener(
            "KEY",
            this
        ){ key, bundle -> //key é a chave e bundle é a informação que estamos recuperando
            val name = bundle.getString("key").toString() //atraves da chave conseguimos recuperar a informação
            Toast.makeText(requireContext(), name, Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}