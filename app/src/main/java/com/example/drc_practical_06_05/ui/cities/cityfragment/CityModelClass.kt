package com.example.drc_practical_06_05.ui.cities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

    class CityList : ArrayList<CityList.CityListItem>(){
    data class CityListItem(
        @SerializedName("coord")
        val coord: Coord,
        @SerializedName("country")
        val country: String,
        @SerializedName("id")
        val id: Double,
        @SerializedName("name")
        val name: String,
        @SerializedName("state")
        val state: String
    ) {
        data class Coord(
            @SerializedName("lat")
            val lat: Double,
            @SerializedName("lon")
            val lon: Double
        )
    }
}


data class Coord(
    @SerializedName("lon")
    @Expose
    val lon: Double = 0.0,
    @SerializedName("lat")
    @Expose
    var lat: Double = 0.0
)