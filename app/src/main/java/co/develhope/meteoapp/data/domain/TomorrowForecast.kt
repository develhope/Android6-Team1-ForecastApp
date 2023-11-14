package co.develhope.meteoapp.data.domain

import org.threeten.bp.OffsetDateTime


data class TomorrowForecast(
    val tomorrowDate: OffsetDateTime,
    val tomorrowDegrees: Int,
    val tomorrowRainfallPicture: Int,
    val tomorrowRainfall: Int,
    val tomorrowArrow: Int,
    val tomorrowPerceivedDegrees: Int,
    val tomorrowUvIndexFactor: Int,
    val tomorrowHumidityDegrees: Int,
    val tomorrowWindDirection: String,
    val tomorrowWindSpeed: Int,
    val tomorrowCoverageFactor: Int,
    val tomorrowRainFactor: Int,
    val forecastIndex: Int
)
