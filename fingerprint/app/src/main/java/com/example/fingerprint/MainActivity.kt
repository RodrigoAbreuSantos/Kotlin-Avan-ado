package com.example.fingerprint

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (BiometricHelper.isBiometricAvailable(this)){//esta pegando a classe e seu metodo

            val executor = ContextCompat.getMainExecutor(this) //quem executa a chamada para a aplicação

            val bio = BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback(){
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {//se sua aplicação teve sucesso

                    super.onAuthenticationSucceeded(result)
                }
            })
            //promptInfo são as informações que vão ser passadas pra biometria,
            // quando a autenticação for feita
            val info = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Titulo")
                .setSubtitle("Sub titulo")
                .setDescription("Descrição")
                .setNegativeButtonText("Cancelar")
                .build()

            bio.authenticate(info)

        }
    }
}