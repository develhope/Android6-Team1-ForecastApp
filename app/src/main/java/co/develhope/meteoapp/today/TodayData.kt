package co.develhope.meteoapp.today

sealed class TodayData(val type : Int) {
    data class TodayItemData(
        //recyclerview item elements

        val todayDate: String,
        val todayWeatherPicture: Int,
        val todayDegrees: String,
        val todayRainfallPicture: Int,
        val todayRainfall: String,
        val todayArrow: Int,

        //reciclerview cardview elements

        val todayPerceived: String,
        val todayPerceivedDegrees: String,
        val todayUvIndex: String,
        val todayUvIndexFactor: String,
        val todayHumidity: String,
        val todayHumidityDegrees: String,
        val todayWind: String,
        val todayWindFactor: String,
        val todayCoverage: String,
        val todayCoverageFactor: String,
        val todayRain: String,
        val todayRainFactor: String

    ) : TodayData(item)

    data class TodayTitleData(
        val todayTitleLocation: String,
        val todayTitleDate: String
    ) : TodayData(title)

    companion object {
        const val item = 1
        const val title = 2
    }
}
//enum class TodayWeatherIcon (
//    val image : Int
//) {
//    SUN(R.drawable.sun),
//    SUNCLOUD(R.drawable.sun_cloud),
//    SUNRAINCLOUD(R.drawable.fluent_emoji_sun_behind_rain_cloud),
//    RAINDROP(R.drawable.raindrop),
//    UNAVAILABLE(R.drawable.ic_launcher_background)
//}

//fun ImageView.setWeatherIcon(weatherIcon: TodayWeatherIcon) {
//    this.setImageResource(weatherIcon.image)
//}

//fun getWeatherIconBasedOnId(forecastIndex : Int) : TodayWeatherIcon {
//    return when (forecastIndex) {
//        1 -> TodayWeatherIcon.SUN
//        2 -> TodayWeatherIcon.SUNCLOUD
//        3 -> TodayWeatherIcon.SUNRAINCLOUD
//        4 -> TodayWeatherIcon.RAINDROP
//        else -> TodayWeatherIcon.UNAVAILABLE
//    }
//}