package co.develhope.meteoapp

import co.develhope.meteoapp.data.local.TodayDataLocal
import co.develhope.meteoapp.data.remote.toTodayDataLocal
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.threeten.bp.OffsetDateTime
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WeatherRepo {
    private val dailyData =
        "temperature_2m,relativehumidity_2m,apparent_temperature,precipitation_probability,rain,weathercode,cloudcover,windspeed_10m,winddirection_10m,uv_index,is_day"
    var weatherService: WeatherService = createRetrofitInstance().create(WeatherService::class.java)

    suspend fun getTodayWeather(lat: Double, lon: Double): TodayDataLocal? {
        val response = weatherService?.getTodayWeather(lat, lon, dailyData, "UTC", 1)
        if (response != null) {
            return response.toTodayDataLocal()
        }
        return null
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