package com.example.openweather_heldersilva.data.response


import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("1h")
    val h: Double
)