package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragment.databinding.FragmentBBinding



class Fragment_B : Fragment() {

    private var _binding: FragmentBBinding? = null//configurando viewBinding nos fragments
    private val binding get() = _binding!!//configurando viewBinding nos fragments

    private val args: Fragment_BArgs by navArgs()//esta recebendo as informações do fragment A

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //configurando viewBinding nos fragments
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()

        getExtra()

    }

    private fun getExtra() { //esta pegando a informação especifica
        val name = args.name
        Toast.makeText(requireContext(), name, Toast.LENGTH_LONG).show()
    }

    private fun initListeners(){
        binding.btnBack.setOnClickListener {
            parentFragmentManager.setFragmentResult(
                "KEY", //esta chave tem que ser igual a chave que esta no fragment A
                bundleOf(Pair("key", "Marcos Almeida")) //aqui esta passando a informação com uma chave
                )
            findNavController().popBackStack() //esta voltando para o fragment anterior
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
