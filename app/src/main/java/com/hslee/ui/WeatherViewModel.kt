package com.hslee.ui

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hslee.adapter.ListAdapter
import com.hslee.domain.Constants
import com.hslee.domain.model.WeatherList
import com.hslee.domain.model.Weathers
import com.hslee.domain.usecase.WeathersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val useCase: WeathersUseCase
) : ViewModel(), DefaultLifecycleObserver {
    val adapter = ListAdapter()

    val weatherList: MutableLiveData<List<WeatherList>> = MutableLiveData<List<WeatherList>>()

    val tempList: ArrayList<WeatherList> = ArrayList()


    init {
        viewModelScope.launch {
            launch {
                val rq = Weathers.RQ("Seoul", "metric", "7523f036b5c93778eb0ca383c4a32442")
                useCase.weather(rq).body()?.also {
                    val title = WeatherList(title = "서울", viewType = Constants.ViewType.TITLE)

                    tempList.add(title)
                    tempList.add(it.list[0])
                    for (i in 0 until it.list.size)
                        if (it.list[i].dt_txt?.contains("00:00:00") == true) {
                            tempList.add(it.list[i])
                        }
                }
            }.join()

            launch {
                val rq = Weathers.RQ("London", "metric", "7523f036b5c93778eb0ca383c4a32442")
                useCase.weather(rq).body()?.also {
                    val title = WeatherList(title = "런던", viewType = Constants.ViewType.TITLE)

                    tempList.add(title)
                    tempList.add(it.list[0])
                    for (i in 0 until it.list.size)
                        if (it.list[i].dt_txt?.contains("00:00:00") == true) {
                            tempList.add(it.list[i])
                        }
                }
            }.join()

            launch {
                val rq = Weathers.RQ("Chicago", "metric", "7523f036b5c93778eb0ca383c4a32442")
                useCase.weather(rq).body()?.also {
                    val title = WeatherList(title = "시카고", viewType = Constants.ViewType.TITLE)

                    tempList.add(title)
                    tempList.add(it.list[0])
                    for (i in 0 until it.list.size)
                        if (it.list[i].dt_txt?.contains("00:00:00") == true) {
                            tempList.add(it.list[i])
                        }

                    weatherList.value = tempList
                }
            }
        }
    }
}