package co.develhope.meteoapp.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.dto.CityInfo
import co.develhope.meteoapp.network.RetrofitInstance
import kotlinx.coroutines.launch

class SearchScreenViewModel : ViewModel() {

    private val _cityList = MutableLiveData<List<CityInfo>>()
    val cityList: LiveData<List<CityInfo>> = _cityList


    fun getCity(cityName: String, language: String) {

        viewModelScope.launch {
            try {

                val place = RetrofitInstance().getPlace(cityName, language = language)
                val currentList = _cityList.value ?: emptyList()
                val updatedList = (currentList + place) as List<CityInfo>
                _cityList.value = updatedList
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
