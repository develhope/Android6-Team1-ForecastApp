package co.develhope.meteoapp.today

fun getWeatherIconBasedOnId(forecastIndex : Int) : WeatherIcon {
    return when (forecastIndex) {
        1 -> WeatherIcon.SUN
        2 -> WeatherIcon.SUNCLOUD
        3 -> WeatherIcon.SUNRAINCLOUD
        4 -> WeatherIcon.RAINDROP
        5 -> WeatherIcon.ARROW
        else -> WeatherIcon.UNAVAILABLE
    }
}