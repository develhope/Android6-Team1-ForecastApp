package co.develhope.meteoapp.network

import android.util.Log
import co.develhope.meteoapp.domainmodel.NetError
import co.develhope.meteoapp.domainmodel.Place
import co.develhope.meteoapp.domainmodel.result.SearchPlaceResult
import co.develhope.meteoapp.dto.GeocodingService
import co.develhope.meteoapp.tomorrow.model.TomorrowData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {

    private val geoCodingUrl = "https://geocoding-api.open-meteo.com/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(geoCodingUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build())
        .build()

    private val api = retrofit.create(GeocodingService::class.java)

    suspend fun getPlace(name: String, language: String): SearchPlaceResult {
        val response = api.getInfoCity(name = name, language = language)
        Log.d("Response", response.toString())

        return try {
            val cityInfoDTO = response.body()

            if (cityInfoDTO != null) {
                val cityInfo : List<Place> = cityInfoDTO.toDomain()
                SearchPlaceResult.Success(cityInfo)
            } else {
                SearchPlaceResult.Error(NetError("Errore durante la richiesta"))

            }
        } catch (e: Exception) {
            SearchPlaceResult.Error(NetError("Errore di rete: ${e.message}"))

        }
    }
}