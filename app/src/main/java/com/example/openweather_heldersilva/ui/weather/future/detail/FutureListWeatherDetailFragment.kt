package com.example.openweather_heldersilva.ui.weather.future.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.openweather_heldersilva.R

class FutureListWeatherDetailFragment : Fragment() {

    companion object {
        fun newInstance() = FutureListWeatherDetailFragment()
    }

    private lateinit var viewModel: FutureListWeatherDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_list_weather_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FutureListWeatherDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}