package com.hslee.domain.model

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("speed")
    var speed: Float,
    @SerializedName("deg")
    var deg: Int,
    @SerializedName("gust")
    var gust: Float
)