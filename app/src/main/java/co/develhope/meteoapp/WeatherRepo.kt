package co.develhope.meteoapp

import co.develhope.meteoapp.data.local.TodayDataLocal
import co.develhope.meteoapp.data.local.TomorrowDataLocal
import co.develhope.meteoapp.data.local.WeeklyDataLocal
import co.develhope.meteoapp.data.remote.toHomeDataLocal
import co.develhope.meteoapp.data.remote.toTodayDataLocal
import co.develhope.meteoapp.data.remote.toTomorrowDataLocal
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import org.threeten.bp.OffsetDateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WeatherRepo {
    private val dailyData =
        "temperature_2m,relativehumidity_2m,apparent_temperature,precipitation_probability,rain,weathercode,cloudcover,windspeed_10m,winddirection_10m,uv_index,is_day"

    private val weeklyData =
        "precipitation_sum,temperature_2m_max,temperature_2m_min,weathercode,windspeed_10m_max"
    var weatherService: WeatherService = createRetrofitInstance().create(WeatherService::class.java)


    suspend fun getHomeWeather(lat: Double, lon: Double): WeeklyDataLocal? {
        val response = weatherService.getWeeklyWeather(lat, lon, weeklyData, "UTC")
        return response.toHomeDataLocal()
    }

    suspend fun getTodayWeather(lat: Double, lon: Double): TodayDataLocal? {
        val response = weatherService.getTodayWeather(lat, lon, dailyData, "UTC", 1)
        return response.toTodayDataLocal()
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
        val tryCatchInterceptor = TryCatchInterceptor()
        val gson1 = GsonBuilder()
            .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeAdapter())
            .create()

        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(tryCatchInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson1))
            .client(httpClient)
            .build()
    }

    class TryCatchInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            return try {
                chain.proceed(chain.request())
            } catch (e: Exception) {
                Response.Builder()
                    .code(418)
                    .message("Errore di rete")
                    .protocol(Protocol.HTTP_1_1)
                    .request(chain.request())
                    .body(ByteArray(0).toResponseBody(null))
                    .build()
            }
        }
    }
}