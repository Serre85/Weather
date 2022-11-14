package com.hslee.domain.model

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("name")
    var name: String,

    @SerializedName("id")
    var id: Int,

    @SerializedName("coord")
    var coord: Coord,

    @SerializedName("country")
    var country: String,

    @SerializedName("population")
    var population: Int,

    @SerializedName("timezone")
    var timezone: Int,

    @SerializedName("sunrise")
    var sunrise: Long,

    @SerializedName("sunset")
    var sunset: Long
)