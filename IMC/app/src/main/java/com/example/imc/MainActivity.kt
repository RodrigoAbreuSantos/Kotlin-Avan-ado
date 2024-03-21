package com.example.imc

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener(this)

    }

    private fun calcular() {
        val pesoText = binding.editPeso.text.toString()
        val alturaText = binding.editAltura.text.toString()

        if (pesoText.isNotEmpty() && alturaText.isNotEmpty()) {
            val peso = pesoText.toFloat()
            val altura = alturaText.toFloat()

            val imc = peso / (altura * altura)

            val classificacao = when {
                imc < 18.5 -> "Abaixo do peso"
                imc >= 18.5 && imc <= 24.9 -> "Peso normal"
                imc >= 25 && imc <= 29.9 -> "Sobrepeso"
                imc >= 30 && imc <= 34.9 -> "Obesidade grau I"
                imc >= 35 && imc <= 39.9 -> "Obesidade grau II"
                else -> "Obesidade grau III"
            }

            binding.textResultado.text = "Seu IMC é: $imc\nClassificação: $classificacao"
            Toast.makeText(this, "Seu IMC é: $imc\nClassificação: $classificacao", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View) {
        // Obtém o Id do elemento clicado
        val id: Int = v.id

        // Verifica se o elemento é o que nos interessa
        if (id == R.id.button_calcular) {
            calcular()
        }
    }


}