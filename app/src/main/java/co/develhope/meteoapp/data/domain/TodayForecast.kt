package co.develhope.meteoapp.data.domain

data class TodayForecast(
    val todayDate: org.threeten.bp.OffsetDateTime,
    val todayDegrees: Int,
    val todayRainfallPicture: WeatherIcon,
    val todayRainfall: Int,
    val todayArrow: WeatherIcon,
    val todayPerceivedDegrees: Int,
    val todayUvIndexFactor: Int,
    val todayHumidityDegrees: Int,
    val todayWindDirection: String,
    val todayWindSpeed: Int,
    val todayCoverageFactor: Int,
    val todayRainFactor: Int,
    val forecastIndex: Int
)
