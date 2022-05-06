package com.example.drc_practical_06_05.ui.cities.cityfragment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.drc_practical_06_05.databinding.ItemCityBinding
import com.example.drc_practical_06_05.ui.cities.CityList

class CityAdapter(
    var context: Context,
    var listCity: CityList
    ) :
        RecyclerView.Adapter<CityAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var binding = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            var data = listCity[position]
            Log.d("==>CITY DATA : ","data : ${data.country}")
            holder.binding.tvCity.text= "( ${data.name} , ${data.country} )"
        }

        override fun getItemCount(): Int {
            return listCity.size
        }

        class ViewHolder(binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root) {
            var binding: ItemCityBinding = binding
        }


}