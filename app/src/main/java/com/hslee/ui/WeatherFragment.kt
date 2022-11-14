package com.hslee.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.hslee.R
import com.hslee.databinding.FragmentWeatherBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeatherFragment : BindingFragment<FragmentWeatherBinding, WeatherViewModel>(R.layout.fragment_weather) {

    override val viewModel: WeatherViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dividerItemDecoration = DividerItemDecoration(context, VERTICAL)
        binding.rvWeather.addItemDecoration(dividerItemDecoration)
    }
}