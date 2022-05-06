package com.example.drc_practical_06_05.ui.cities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CityModelClass(
    @SerializedName("country")
    @Expose
    var country: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("_id")
    @Expose
    var id: Int,
    @SerializedName("coord")
    @Expose
    var coord: Coord
)

data class Coord(
    @SerializedName("lon")
    @Expose
    val lon: Double = 0.0,
    @SerializedName("lat")
    @Expose
    var lat: Double = 0.0
)