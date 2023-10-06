package co.develhope.meteoapp.data.domain

import org.threeten.bp.OffsetDateTime

sealed class HomeForecast(val id: Int) {

    data class HomeToday(
        val homeTodayDate: OffsetDateTime,
        val homeMinTemperature: Int,
        val homeMaxTemperature: Int,
        val homeWeatherIcon: WeatherIcon,
        val homePrecipitation: Int,
        val homeWindSpeed: Int,
    ) : HomeForecast(HomeTodayId)

    data class HomeSpecificDay(
        val homeTodayDate: OffsetDateTime,
        val homeMinTemperature: Int,
        val homeMaxTemperature: Int,
        val homeWeatherIcon: WeatherIcon,
        val homePrecipitation: Int,
        val homeWindSpeed: Int,
    ) : HomeForecast(HomeSpecificDayId)

    data class HomeTitle(
        val homePlace: String
    ) : HomeForecast(HomeTitleId)

    object HomeSubtitle : HomeForecast(HomeSubtitleId)

    companion object {
        const val HomeTodayId = 1
        const val HomeSpecificDayId = 2
        const val HomeTitleId = 3
        const val HomeSubtitleId = 4

    }
}