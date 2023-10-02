package co.develhope.meteoapp.network

import co.develhope.meteoapp.domainmodel.Place
import co.develhope.meteoapp.dto.GeocodingService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    private val geoCodingUrl = "https://geocoding-api.open-meteo.com/v1/"


    val retrofit = Retrofit.Builder()
        .baseUrl(geoCodingUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(GeocodingService::class.java)

} suspend fun getPlace() : List<Place> {

}