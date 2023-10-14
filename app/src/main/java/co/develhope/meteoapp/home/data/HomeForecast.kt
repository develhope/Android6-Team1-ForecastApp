package co.develhope.meteoapp.home.data

import co.develhope.meteoapp.data.domain.WeatherIcon
import org.threeten.bp.OffsetDateTime

sealed class HomeForecast(val id: Int) {


    data class HomeDays(
        val date: OffsetDateTime,
        val minTemperature: Int,
        val maxTemperature: Int,
        val weatherIcon: Int,
        val precipitation: Int,
        val windSpeed: Int,
    ) : HomeForecast(HomeDaysId)

    data class HomeTitle(
        val textToShow: String
    ) : HomeForecast(HomeTitleId)

    object HomeSubtitle : HomeForecast(HomeSubtitleId)

    data class HomeToday(
        val date: OffsetDateTime,
        val minTemperature: Int,
        val maxTemperature: Int,
        val weatherIcon: Int,
        val precipitation: Int,
        val windSpeed: Int,
    ) : HomeForecast(HomeTodayId)



    companion object {
        const val HomeDaysId = 1
        const val HomeTitleId = 2
        const val HomeSubtitleId = 3
        const val HomeTodayId = 4


    }
}
