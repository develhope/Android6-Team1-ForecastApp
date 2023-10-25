package co.develhope.meteoapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import co.develhope.meteoapp.data.domain.TodayForecast
import co.develhope.meteoapp.data.domain.TomorrowForecast
import co.develhope.meteoapp.data.domain.WeatherIcon
import co.develhope.meteoapp.domainmodel.Place
import co.develhope.meteoapp.home.data.HomeForecast
import co.develhope.meteoapp.tomorrow.model.TomorrowData
import org.threeten.bp.OffsetDateTime

object Data {
    fun getTodayTitle(): String = "Palermo, Sicilia"
    fun getTodayForecast(): List<TodayForecast> = listOf()


    fun getTomorrowList(): List<TomorrowData> {
        return listOf(
            TomorrowData.TomorrowTitle(
                "Palermo, Sicilia",
                OffsetDateTime.now().plusDays(1)
            ),
            TomorrowData.TomorrowCard(
                TomorrowForecast(
                    OffsetDateTime.now(),
                    12,
                    WeatherIcon.ARROW,
                    13,
                    WeatherIcon.RAINDROP,
                    12,
                    14,
                    1,
                    "NNE",
                    11,
                    1,
                    7,
                    1
                )
            ),
            TomorrowData.TomorrowCard(
                TomorrowForecast(
                    OffsetDateTime.now(),
                    12,
                    WeatherIcon.ARROW,
                    13,
                    WeatherIcon.RAINDROP,
                    12,
                    14,
                    1,
                    "NNE",
                    11,
                    1,
                    7,
                    1
                )
            ),
            TomorrowData.TomorrowCard(
                TomorrowForecast(
                    OffsetDateTime.now(),
                    12,
                    WeatherIcon.ARROW,
                    13,
                    WeatherIcon.RAINDROP,
                    12,
                    14,
                    1,
                    "NNE",
                    11,
                    1,
                    7,
                    1
                )
            ),
            TomorrowData.TomorrowCard(
                TomorrowForecast(
                    OffsetDateTime.now(),
                    12,
                    WeatherIcon.ARROW,
                    13,
                    WeatherIcon.RAINDROP,
                    12,
                    14,
                    1,
                    "NNE",
                    11,
                    1,
                    7,
                    1
                )
            ),
            TomorrowData.TomorrowCard(
                TomorrowForecast(
                    OffsetDateTime.now(),
                    12,
                    WeatherIcon.ARROW,
                    13,
                    WeatherIcon.RAINDROP,
                    12,
                    14,
                    1,
                    "NNE",
                    11,
                    1,
                    7,
                    1
                )
            ),
            TomorrowData.TomorrowCard(
                TomorrowForecast(
                    OffsetDateTime.now(),
                    12,
                    WeatherIcon.ARROW,
                    13,
                    WeatherIcon.RAINDROP,
                    12,
                    14,
                    1,
                    "NNE",
                    11,
                    1,
                    7,
                    1
                )
            ),
            TomorrowData.TomorrowCard(
                TomorrowForecast(
                    OffsetDateTime.now(),
                    12,
                    WeatherIcon.ARROW,
                    13,
                    WeatherIcon.RAINDROP,
                    12,
                    14,
                    1,
                    "NNE",
                    11,
                    1,
                    7,
                    1
                )
            ),
            TomorrowData.TomorrowCard(
                TomorrowForecast(
                    OffsetDateTime.now(),
                    12,
                    WeatherIcon.ARROW,
                    13,
                    WeatherIcon.RAINDROP,
                    12,
                    14,
                    1,
                    "NNE",
                    11,
                    1,
                    7,
                    1
                )
            ),
        )
    }

    fun getHomeList(): List<HomeForecast> {
        return listOf(
            HomeForecast.HomeTitle("Palermo, Sicilia"),
            HomeForecast.HomeDays(
                date = OffsetDateTime.now(),
                minTemperature = 0,
                maxTemperature = 0,
                weatherIcon = WeatherIcon.SUN,
                precipitation = 0,
                windSpeed = 0
            ),
            HomeForecast.HomeSubtitle("Prossimi 5 giorni"),
            HomeForecast.HomeDays(
                date = OffsetDateTime.now().plusDays(1),
                minTemperature = 0,
                maxTemperature = 0,
                weatherIcon = WeatherIcon.SUN,
                precipitation = 0,
                windSpeed = 0
            ),
            HomeForecast.HomeDays(
                date = OffsetDateTime.now().plusDays(2),
                minTemperature = 0,
                maxTemperature = 0,
                weatherIcon = WeatherIcon.SUN,
                precipitation = 0,
                windSpeed = 0
            ),
            HomeForecast.HomeDays(
                date = OffsetDateTime.now().plusDays(3),
                minTemperature = 0,
                maxTemperature = 0,
                weatherIcon = WeatherIcon.SUN,
                precipitation = 0,
                windSpeed = 0
            ),
            HomeForecast.HomeDays(
                date = OffsetDateTime.now().plusDays(4),
                minTemperature = 0,
                maxTemperature = 0,
                weatherIcon = WeatherIcon.SUN,
                precipitation = 0,
                windSpeed = 0
            ),
            HomeForecast.HomeDays(
                date = OffsetDateTime.now().plusDays(5),
                minTemperature = 0,
                maxTemperature = 0,
                weatherIcon = WeatherIcon.SUN,
                precipitation = 0,
                windSpeed = 0
            )
        )
    }

    private var selectedPlace : Place? = null
    fun saveSelectedPlace(place: Place) {
        selectedPlace = place
    }
    //TO DO use this to read the selected place in home and specificDay screen
    fun getSelectedPlace() = selectedPlace
}