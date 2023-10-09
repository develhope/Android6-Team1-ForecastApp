package co.develhope.meteoapp

import co.develhope.meteoapp.data.remote.TodayDataRemote
import retrofit2.Response
import retrofit2.http.GET
interface WeatherService {

    @GET("/v1/forecast")
    suspend fun getTodayWeather(
    ): Response<TodayDataRemote>
}