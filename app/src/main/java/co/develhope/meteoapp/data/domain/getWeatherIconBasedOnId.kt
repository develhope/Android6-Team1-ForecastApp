package co.develhope.meteoapp.data.domain

fun getWeatherIconBasedOnId(forecastIndex: Int): WeatherIcon {
    return when (forecastIndex) {
        0 -> WeatherIcon.SUN
        1 -> WeatherIcon.SUNCLOUD
        2 -> WeatherIcon.SUNRAINCLOUD
        3 -> WeatherIcon.RAINDROP
        4 -> WeatherIcon.ARROW
        else -> WeatherIcon.UNAVAILABLE
    }
}