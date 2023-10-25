package co.develhope.meteoapp.home.data

import co.develhope.meteoapp.data.domain.WeatherIcon
import org.threeten.bp.OffsetDateTime

sealed class HomeForecast(val id: Int) {


    data class HomeDays(
        val date: OffsetDateTime,
        val minTemperature: Int,
        val maxTemperature: Int,
        val weatherIcon: WeatherIcon,
        val precipitation: Int,
        val windSpeed: Int,
    ) : HomeForecast(HomeDaysId)

    data class HomeTitle(
        val textToShow: String
    ) : HomeForecast(HomeTitleId)

    data class HomeSubtitle(
        val textToShow: String
    ) : HomeForecast(HomeSubtitleId)

    companion object {
        const val HomeDaysId = 1
        const val HomeTitleId = 2
        const val HomeSubtitleId = 3
    }
}
