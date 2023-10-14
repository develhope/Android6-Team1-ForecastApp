package co.develhope.meteoapp.data

import co.develhope.meteoapp.data.domain.TodayForecast
import co.develhope.meteoapp.data.domain.TomorrowForecast
import co.develhope.meteoapp.data.domain.WeatherIcon
import co.develhope.meteoapp.home.data.HomeForecast
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

object Data {

    private var selectedDay: OffsetDateTime? = OffsetDateTime.now().plusDays(1)

    fun saveDate (savedDate : OffsetDateTime){
        selectedDay = savedDate
    }
    fun getTodayTitle(): String = "Palermo, Sicilia"
    fun getTodayForecast(): List<TodayForecast> = listOf()

    fun getTomorrowTitle(): String = "Palermo, Sicilia"

    fun getTomorrowForecast(): List<TomorrowForecast> = listOf()


//    fun getHomeList(): List<HomeForecast> {
//        return listOf(
//            HomeForecast.HomeTitle("Palermo, Sicilia"),
//            HomeForecast.HomeDays(
//                date = OffsetDateTime.now(),
//                minTemperature = 0,
//                maxTemperature = 0,
//                weatherIcon = WeatherIcon.SUN,
//                precipitation = 0,
//                windSpeed = 0
//            ),
//            HomeForecast.HomeSubtitle("Prossimi 5 giorni"),
//            HomeForecast.HomeDays(
//                date = OffsetDateTime.now().plusDays(1),
//                minTemperature = 0,
//                maxTemperature = 0,
//                weatherIcon = WeatherIcon.SUN,
//                precipitation = 0,
//                windSpeed = 0
//            ),
//            HomeForecast.HomeDays(
//                date = OffsetDateTime.now().plusDays(2),
//                minTemperature = 0,
//                maxTemperature = 0,
//                weatherIcon = WeatherIcon.SUN,
//                precipitation = 0,
//                windSpeed = 0
//            ),
//            HomeForecast.HomeDays(
//                date = OffsetDateTime.now().plusDays(3),
//                minTemperature = 0,
//                maxTemperature = 0,
//                weatherIcon = WeatherIcon.SUN,
//                precipitation = 0,
//                windSpeed = 0
//            ),
//            HomeForecast.HomeDays(
//                date = OffsetDateTime.now().plusDays(4),
//                minTemperature = 0,
//                maxTemperature = 0,
//                weatherIcon = WeatherIcon.SUN,
//                precipitation = 0,
//                windSpeed = 0
//            ),
//            HomeForecast.HomeDays(
//                date = OffsetDateTime.now().plusDays(5),
//                minTemperature = 0,
//                maxTemperature = 0,
//                weatherIcon = WeatherIcon.SUN,
//                precipitation = 0,
//                windSpeed = 0
//            )
//        )
//    }
}