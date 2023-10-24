package co.develhope.meteoapp

import co.develhope.meteoapp.dto.CityInfoDTO
import retrofit2.Response

class CityInfoLocal : ArrayList<CityInfoLocal.ResultLocal>(){
    data class ResultLocal(
        val name : String?,
        val admin1 : String?,
        val lat : Double?,
        val long : Double?
    )
}

fun Response<CityInfoDTO>.toSearchCityInfo() : CityInfoLocal?{
    return if (this.isSuccessful) {
        val response = this.body()
        val model = CityInfoLocal()

        response?.results?.forEach {
            model.add(CityInfoLocal.ResultLocal(
                name = it.name,
                admin1 = it.admin1,
                lat = it.latitude,
                long = it.longitude
            ))
        }
        model
    }else{
        null
    }
}
