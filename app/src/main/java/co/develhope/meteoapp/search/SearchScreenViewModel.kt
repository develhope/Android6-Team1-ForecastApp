package co.develhope.meteoapp.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.domainmodel.Place
import co.develhope.meteoapp.domainmodel.result.SearchPlaceResult
import co.develhope.meteoapp.domainmodel.result.SearchPlaceResult.Error
import co.develhope.meteoapp.domainmodel.result.SearchPlaceResult.Success
import co.develhope.meteoapp.network.RetrofitInstance
import kotlinx.coroutines.launch

class SearchScreenViewModel : ViewModel() {

    private val _cityList = MutableLiveData<List<Place>>()
    val cityList: LiveData<List<Place>> = _cityList


    fun getCity(cityName: String, language: String) {
        viewModelScope.launch {
            try {

                Log.d("SearchScreenViewModel", "Before network call: $cityName")
                when (val result: SearchPlaceResult =
                    RetrofitInstance().getPlace(cityName, language = language)) {

                Log.d("GelPlace", "cityName: $cityName - language: $language")
                val result : SearchPlaceResult = RetrofitInstance().getPlace(cityName, language = language)

                when(result) {

                    is Error -> Log.e("ERROR", "network error ")
                    is Success -> {
                        Log.d("SearchScreenViewModel", "Received data: ${result.data}")
                        _cityList.value = result.data

                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}