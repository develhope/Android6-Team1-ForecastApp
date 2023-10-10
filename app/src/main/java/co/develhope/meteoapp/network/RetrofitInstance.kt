package co.develhope.meteoapp.network

import co.develhope.meteoapp.domainmodel.result.EventActionResult
import co.develhope.meteoapp.dto.GeocodingService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


data class UniwhereError(val message: String)
class RetrofitInstance {

    private val geoCodingUrl = "https://geocoding-api.open-meteo.com/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(geoCodingUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(GeocodingService::class.java)

    suspend fun getPlace(name: String, language: String): EventActionResult {
        val response = api.getInfoCity(name = name, language = language)
        return try {
            val cityInfoDTO = response.body()

            if (cityInfoDTO != null) {
                val cityInfo =
                    cityInfoDTO.toDomain()
                EventActionResult.Success(cityInfo)
            } else {
                EventActionResult.Error(UniwhereError("Errore durante la richiesta"))
            }
        } catch (e: Exception) {
            EventActionResult.Error(UniwhereError("Errore di rete: ${e.message}"))
        }
    }
}
