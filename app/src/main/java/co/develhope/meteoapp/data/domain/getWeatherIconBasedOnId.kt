package co.develhope.meteoapp.data.domain

fun getWeatherIconBasedOnId(forecastIndex: Int): WeatherIcon {
    return when (forecastIndex) {
        0 -> WeatherIcon.SUN
        1, 2, 3 -> WeatherIcon.SUNCLOUD
        51, 53, 55, 56, 57, 61, 63, 65, 66, 67, 80, 81, 82 -> WeatherIcon.SUNRAINCLOUD
        4 -> WeatherIcon.RAINDROP
        5 -> WeatherIcon.ARROW
        else -> WeatherIcon.UNAVAILABLE
    }
}