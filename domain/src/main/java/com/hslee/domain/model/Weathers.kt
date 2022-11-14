package com.hslee.domain.model

import com.google.gson.annotations.SerializedName

object Weathers {
    class RQ(var q: String, var metric: String, var appid: String)

    class RS(
        @SerializedName("cod")
        var cod: Int,

        @SerializedName("message")
        var message: Int,

        @SerializedName("cnt")
        var cnt: Int,

        @SerializedName("list")
        var list: ArrayList<WeatherList>,

        @SerializedName("city")
        var city: City
    )
}