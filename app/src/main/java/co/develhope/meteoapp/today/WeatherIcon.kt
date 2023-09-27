package co.develhope.meteoapp.today

import co.develhope.meteoapp.R

enum class WeatherIcon(val image: Int) {

    SUN(R.drawable.sun),
    SUNCLOUD(R.drawable.sun_cloud),
    SUNRAINCLOUD(R.drawable.fluent_emoji_sun_behind_rain_cloud),
    MOON(R.drawable.fluent_emoji_crescent_moon),
    RAINDROP(R.drawable.raindrop),
    ARROW(R.drawable.arrow),
    UNAVAILABLE(R.drawable.frame_47)
}