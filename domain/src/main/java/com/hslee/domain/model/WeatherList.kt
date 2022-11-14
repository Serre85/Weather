package com.hslee.domain.model

import android.util.Log
import com.google.gson.annotations.SerializedName
import com.hslee.domain.Constants
import java.text.SimpleDateFormat
import java.util.*

data class WeatherList(
    @SerializedName("dt")
    var dt: Long? = null,

    @SerializedName("main")
    var main: Main? = null,

    @SerializedName("weather")
    var weather: ArrayList<Weather>? = null,

    @SerializedName("clouds")
    var clouds: Clouds? = null,

    @SerializedName("wind")
    var wind: Wind? = null,

    @SerializedName("visibility")
    var visibility: Int? = null,

    @SerializedName("pop")
    var pop: Float? = null,

    @SerializedName("rain")
    var rain: Rain? = null,

    @SerializedName("sys")
    var sys: Sys? = null,

    @SerializedName("dt_txt")
    var dt_txt: String? = null,

    var title: String? = null,

    var viewType: Int = Constants.ViewType.CONTENT
) {
    fun setDate(): String {
        val date = SimpleDateFormat("yyyy-MM-dd")
        val temp = date.parse(dt_txt)
        val now = date.format(System.currentTimeMillis())
        val item = date.format(temp)

        if (dt_txt?.contains(now) == true) {
            return "Today"
        } else {
            val nowFormat = SimpleDateFormat("yyyy-MM-dd").parse(now)
            val itemFormat = SimpleDateFormat("yyyy-MM-dd").parse(item)

            val diffSec = (nowFormat.time - itemFormat.time) / 1000
            val diffDays = diffSec / (24 * 60 * 60)

            val msg = if (diffDays >= -1) {
                "Tomorrow"
            } else {
                item
            }

            return msg
        }
    }
}