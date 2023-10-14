package co.develhope.meteoapp

import co.develhope.meteoapp.data.remote.TodayDataRemote
import co.develhope.meteoapp.data.remote.TomorrowDataRemote
import co.develhope.meteoapp.data.remote.WeeklyDataRemote
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


    @GET("/v1/forecast")
    suspend fun getTomorrowWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") hourly: String,
        @Query("timezone") timezone: String,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
    ): Response<TomorrowDataRemote>

    @GET("/v1/forecast")
    suspend fun getWeeklyWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("daily") daily : String,
        @Query("timezone") timezone: String
    ): Response<WeeklyDataRemote>

}