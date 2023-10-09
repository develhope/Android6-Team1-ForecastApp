package co.develhope.meteoapp.data.remote
import com.google.gson.annotations.SerializedName


data class TodayDataRemote(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather?,
    @SerializedName("current_weather_interval_seconds")
    val currentWeatherIntervalSeconds: Int?,
    @SerializedName("current_weather_units")
    val currentWeatherUnits: CurrentWeatherUnits?,
    @SerializedName("elevation")
    val elevation: Int?,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double?,
    @SerializedName("hourly")
    val hourly: Hourly?,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String?,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int?
)

data class CurrentWeather(
    @SerializedName("is_day")
    val isDay: Int?,
    @SerializedName("temperature")
    val temperature: Double?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("weathercode")
    val weathercode: Int?,
    @SerializedName("winddirection")
    val winddirection: Int?,
    @SerializedName("windspeed")
    val windspeed: Double?
)

data class CurrentWeatherUnits(
    @SerializedName("is_day")
    val isDay: String?,
    @SerializedName("temperature")
    val temperature: String?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("weathercode")
    val weathercode: String?,
    @SerializedName("winddirection")
    val winddirection: String?,
    @SerializedName("windspeed")
    val windspeed: String?
)

data class Hourly(
    @SerializedName("rain")
    val rain: List<Any?>?,
    @SerializedName("showers")
    val showers: List<Any?>?,
    @SerializedName("snowfall")
    val snowfall: List<Any?>?,
    @SerializedName("temperature_2m")
    val temperature2m: List<Any?>?,
    @SerializedName("time")
    val time: List<String?>?,
    @SerializedName("weathercode")
    val weathercode: List<Any?>?,
    @SerializedName("windspeed_10m")
    val windspeed10m: List<Any?>?
)

data class HourlyUnits(
    @SerializedName("rain")
    val rain: String?,
    @SerializedName("showers")
    val showers: String?,
    @SerializedName("snowfall")
    val snowfall: String?,
    @SerializedName("temperature_2m")
    val temperature2m: String?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("weathercode")
    val weathercode: String?,
    @SerializedName("windspeed_10m")
    val windspeed10m: String?
)