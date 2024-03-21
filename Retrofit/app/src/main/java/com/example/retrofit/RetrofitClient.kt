package com.example.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {

    companion object {

        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private  fun getRetrofitInstance(): Retrofit {
            val http = OkHttpClient.Builder() //esta classe vai conectar com a internet
        // e o retrofit vai usar ela e retornar

            if (!::INSTANCE.isInitialized){
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build()) //quem faz a chamada para internet
                    .addConverterFactory(GsonConverterFactory.create()) //depois de conectar a internt
                    // converte
                    .build() //pode instanciar
            }
            return INSTANCE
        }

        fun creatPostService(): PostService{
            return getRetrofitInstance().create(PostService::class.java)
        }
    }
}