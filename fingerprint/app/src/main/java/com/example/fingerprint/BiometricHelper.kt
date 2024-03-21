package com.example.fingerprint

import android.content.Context
import android.os.Build
import androidx.biometric.BiometricManager


class BiometricHelper {
    companion object {  //para não instanciar a classe toda vez que for usar
        fun isBiometricAvailable(context: Context): Boolean {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                //se a versão da api for menor
                return false
            }

            val biometricManager: BiometricManager = BiometricManager.from(context)
            when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)) { //o strong se vc tem uma diferença de 5% na digital ele não deixa
                BiometricManager.BIOMETRIC_SUCCESS -> return true //sucesso
                BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> return false //não tem biometrica na sua api
                BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> return false//esta dando pau
                BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> return false //nosso dispositivo não tem nenhuma digital cadastrada
            }

            return false
        }
    }
}

