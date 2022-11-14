package com.hslee.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hslee.R
import com.hslee.adapter.ListAdapter
import com.hslee.domain.model.WeatherList

object Adapter {

    @BindingAdapter(value = ["adapter", "content"])
    @JvmStatic
    fun RecyclerView.setAdapter(adapter: ListAdapter?, list: MutableList<WeatherList>?) {
        this.adapter = adapter
        adapter?.submitList(list)
    }

    @BindingAdapter("text")
    @JvmStatic
    fun TextView.setText(text: String?) {
        var weather = when (text) {
            "Clear" -> {
                context.getString(R.string.weather_sunny)
            }
            "Clouds" -> {
                context.getString(R.string.weather_cloudy)
            }
            "Rain" -> {
                context.getString(R.string.weather_rainy)
            }
            "Snow" -> {
                context.getString(R.string.weather_snowy)
            }
            "Fog" -> {
                context.getString(R.string.weather_foggy)
            }
            "Thunder" -> {
                context.getString(R.string.weather_thunder)
            }
            else -> {
                context.getString(R.string.weather_sunny)
            }
        }
        this.text = weather
    }
}