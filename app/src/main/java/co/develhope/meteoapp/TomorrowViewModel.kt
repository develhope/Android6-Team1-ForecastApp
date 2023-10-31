package co.develhope.meteoapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.data.local.TomorrowDataLocal
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TomorrowViewModel : ViewModel() {

    val repo = WeatherRepo()

    private val _result = MutableLiveData<TomorrowDataLocal?>()

    val result: LiveData<TomorrowDataLocal?>
        get() = _result

    fun getDailyInfo(
        lat: Double,
        lon: Double,
        start:String,
        end:String
    ) {
        viewModelScope.launch(IO) {
            val response = repo.getTomorrowWeather(lat, lon,start,end)
            if (response != null) {
                _result.postValue(response)
                Log.i("Network Data", "$response")
            } else {
                Log.e("Network Error", "Could not achieve Network Call")
            }
        }
    }
}
