package co.develhope.meteoapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.data.local.TodayDataLocal
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DailyViewModel : ViewModel() {

    val repo = WeatherRepo()

    private val _result = MutableLiveData<TodayDataLocal?>()

    val result : LiveData<TodayDataLocal?>
        get() = _result
    fun getDailyInfo(
        lat: Double,
        lon: Double
    ) {
        viewModelScope.launch(IO) {
            val response = repo.getTodayWeather(lat,lon)
            if (response != null) {
                _result.postValue(response)
                Log.i("Network Data", "$response")
            } else {
                Log.e("Network Error", "Could not achieve Network Call")
            }
        }
    }
}
