package co.develhope.meteoapp

import co.develhope.meteoapp.data.local.TodayDataLocal
import co.develhope.meteoapp.data.local.TomorrowDataLocal
import co.develhope.meteoapp.data.local.WeeklyDataLocal
import co.develhope.meteoapp.data.remote.toHomeDataLocal
import co.develhope.meteoapp.data.remote.toTodayDataLocal
import co.develhope.meteoapp.data.remote.toTomorrowDataLocal
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale
import java.util.concurrent.TimeUnit

class WeatherRepo {


    val startDay = OffsetDateTime.now().plusDays(1)
    val endDay = OffsetDateTime.now().plusDays(1).plusHours(1)
    val formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD", Locale.ITALIAN)
    private val dailyData =
        "temperature_2m,relativehumidity_2m,apparent_temperature,precipitation_probability,rain,weathercode,cloudcover,windspeed_10m,winddirection_10m,uv_index,is_day"

    private val weeklyData =
        "precipitation_sum,temperature_2m_max,temperature_2m_min,weathercode,windspeed_10m_max"
    var weatherService: WeatherService = createRetrofitInstance().create(WeatherService::class.java)


    suspend fun getHomeWeather(lat: Double, lon: Double): WeeklyDataLocal? {
        val response = weatherService?.getWeeklyWeather(lat, lon, weeklyData, "UTC")
        if (response != null) {
            return response.toHomeDataLocal()
        }
        return null
    }

    suspend fun getTodayWeather(lat: Double, lon: Double): TodayDataLocal? {

        val response = weatherService?.getTodayWeather(lat, lon, dailyData, "UTC", 1)
        return response?.toTodayDataLocal()

        if (response != null) {
            return response.toTodayDataLocal()
        }
        return null
    }

    suspend fun getTomorrowWeather(lat: Double, lon: Double,start:String,end:String): TomorrowDataLocal? {
        val response = weatherService.getTomorrowWeather(
            lat,
            lon,
            dailyData,
            "UTC",
            start,
            end
        )

        return response.toTomorrowDataLocal()
    }


    fun createRetrofitInstance(): Retrofit {
        val baseUrl = "https://api.open-meteo.com"
        val loggingInterceptor = HttpLoggingInterceptor()
        val gson1 = GsonBuilder()
            .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeAdapter())
            .create()

        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson1))
            .client(httpClient)
            .build()
    }
}