package co.develhope.meteoapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.data.local.TomorrowDataLocal
import co.develhope.meteoapp.data.local.WeeklyDataLocal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    val repo = WeatherRepo()
    private val _result = MutableLiveData<WeeklyDataLocal?>()
    val result: LiveData<WeeklyDataLocal?>
        get() = _result

    fun getDailyInfo(
        lat: Double,
        lon: Double
    ) {viewModelScope.launch(Dispatchers.IO) {
        val response = repo.getHomeWeather(lat, lon)
        if (response != null) {
            _result.postValue(response)
            Log.i("Network Data", "$response")
        } else {
            Log.e("Network Error", "Could not achieve Network Call")
        }
    }
    }
}