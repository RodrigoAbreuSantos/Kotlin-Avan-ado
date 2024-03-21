package com.example.retrofit

import com.google.gson.annotations.SerializedName

class PostEntity {

    @SerializedName("userId") //dentro fala qual é o atributo que vai ser convertido,
    // por exemplo veio user_id, mas vc converte para userId
    var userId: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String = ""

    @SerializedName("body")
    var body: String = ""
}