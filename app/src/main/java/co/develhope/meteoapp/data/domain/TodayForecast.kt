package co.develhope.meteoapp.data.domain

import org.threeten.bp.OffsetDateTime

data class TodayForecast(
    val todayDate: OffsetDateTime,
    val todayDegrees: Int,
    val todayRainfallPicture: Int,
    val todayRainfall: Int,
    val todayArrow: Int,
    val todayPerceivedDegrees: Int,
    val todayUvIndexFactor: Int,
    val todayHumidityDegrees: Int,
    val todayWindDirection: String,
    val todayWindSpeed: Int,
    val todayCoverageFactor: Int,
    val todayRainFactor: Int,
    val forecastIndex: Int
)
