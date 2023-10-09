package co.develhope.meteoapp

import co.develhope.meteoapp.data.remote.TodayDataRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("/v1/forecast")
    suspend fun getTodayWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") hourly: String,
        @Query("timezone") timezone: String,
        @Query("forecast_days") forecastDays: Int
    ): Response<TodayDataRemote>
}