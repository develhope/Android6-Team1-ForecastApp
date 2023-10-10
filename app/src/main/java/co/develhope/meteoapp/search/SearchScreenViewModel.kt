package co.develhope.meteoapp.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.domainmodel.result.EventActionResult
import co.develhope.meteoapp.dto.CityInfo
import co.develhope.meteoapp.network.RetrofitInstance
import kotlinx.coroutines.launch

class SearchScreenViewModel : ViewModel() {

    private val _cityList = MutableLiveData<List<CityInfo>>()
    val cityList: LiveData<List<CityInfo>> = _cityList

    /**fun getCityList(): List<Search.SearchPlace>? {
        //return _cityList.value
    }**/

    fun getCity(cityName: String, language: String) {
        viewModelScope.launch {
            try {
                val place = RetrofitInstance().getPlace(cityName, language = language)
                _cityList.value = (_cityList.value?.plus(place) ?: listOf(place)) as List<CityInfo>?
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}