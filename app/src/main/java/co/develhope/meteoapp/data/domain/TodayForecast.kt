package co.develhope.meteoapp.data.domain

import java.time.OffsetDateTime

data class TodayForecast(
    val todayDate: OffsetDateTime,
    val todayWeatherPicture: WeatherIcon,
    val todayDegrees: Int,
    val todayRainfallPicture : WeatherIcon,
    val todayRainfall: Int,
    val todayArrow: WeatherIcon,

    val todayPerceivedDegrees: Int,
    val todayUvIndexFactor: Int,
    val todayHumidityDegrees: Int,
    val todayWindDirection: String,
    val todayWindSpeed: Int,
    val todayCoverageFactor: Int,
    val todayRainFactor: Int
)
