package co.develhope.meteoapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import co.develhope.meteoapp.data.domain.TodayForecast
import co.develhope.meteoapp.data.domain.TomorrowForecast
import co.develhope.meteoapp.data.domain.WeatherIcon
import co.develhope.meteoapp.home.data.HomeForecast
import co.develhope.meteoapp.tomorrow.model.TomorrowData
import org.threeten.bp.OffsetDateTime

object Data {
    fun getTodayTitle(): String = "Palermo, Sicilia"

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTodayForecast(): List<TodayForecast> = listOf(
        TodayForecast(
            todayDate = OffsetDateTime.now(),
            todayDegrees = 31,
            todayRainfallPicture = WeatherIcon.RAINDROP,
            todayRainfall = 0,
            todayArrow = WeatherIcon.ARROW,
            todayPerceivedDegrees = 45,
            todayUvIndexFactor = 5,
            todayHumidityDegrees = 60,
            todayWindDirection = "SSE",
            todayWindSpeed = 7,
            todayCoverageFactor = 24,
            todayRainFactor = 0,
            forecastIndex = 1
        ),
        TodayForecast(
            todayDate = OffsetDateTime.now().plusHours(1),
            todayDegrees = 29,
            todayRainfallPicture = WeatherIcon.RAINDROP,
            todayRainfall = 0,
            todayArrow = WeatherIcon.ARROW,
            todayPerceivedDegrees = 45,
            todayUvIndexFactor = 5,
            todayHumidityDegrees = 60,
            todayWindDirection = "SSE",
            todayWindSpeed = 7,
            todayCoverageFactor = 24,
            todayRainFactor = 0,
            forecastIndex = 1
        ),
        TodayForecast(
            todayDate = OffsetDateTime.now().plusHours(2),
            todayDegrees = 30,
            todayRainfallPicture = WeatherIcon.RAINDROP,
            todayRainfall = 0,
            todayArrow = WeatherIcon.ARROW,
            todayPerceivedDegrees = 45,
            todayUvIndexFactor = 5,
            todayHumidityDegrees = 60,
            todayWindDirection = "SSE",
            todayWindSpeed = 7,
            todayCoverageFactor = 24,
            todayRainFactor = 0,
            forecastIndex = 1
        ),
        TodayForecast(
            todayDate = OffsetDateTime.now().plusHours(3),
            todayDegrees = 32,
            todayRainfallPicture = WeatherIcon.RAINDROP,
            todayRainfall = 60,
            todayArrow = WeatherIcon.ARROW,
            todayPerceivedDegrees = 45,
            todayUvIndexFactor = 5,
            todayHumidityDegrees = 60,
            todayWindDirection = "SSE",
            todayWindSpeed = 7,
            todayCoverageFactor = 24,
            todayRainFactor = 0,
            forecastIndex = 3
        ),
        TodayForecast(
            todayDate = OffsetDateTime.now().plusHours(4),
            todayDegrees = 28,
            todayRainfallPicture = WeatherIcon.RAINDROP,
            todayRainfall = 70,
            todayArrow = WeatherIcon.ARROW,
            todayPerceivedDegrees = 45,
            todayUvIndexFactor = 5,
            todayHumidityDegrees = 60,
            todayWindDirection = "SSE",
            todayWindSpeed = 7,
            todayCoverageFactor = 24,
            todayRainFactor = 0,
            forecastIndex = 3
        ),
        TodayForecast(
            todayDate = OffsetDateTime.now().plusHours(5),
            todayDegrees = 25,
            todayRainfallPicture = WeatherIcon.RAINDROP,
            todayRainfall = 20,
            todayArrow = WeatherIcon.ARROW,
            todayPerceivedDegrees = 45,
            todayUvIndexFactor = 5,
            todayHumidityDegrees = 60,
            todayWindDirection = "SSE",
            todayWindSpeed = 7,
            todayCoverageFactor = 24,
            todayRainFactor = 0,
            forecastIndex = 3
        ),
        TodayForecast(
            todayDate = OffsetDateTime.now().plusHours(6),
            todayDegrees = 29,
            todayRainfallPicture = WeatherIcon.RAINDROP,
            todayRainfall = 0,
            todayArrow = WeatherIcon.ARROW,
            todayPerceivedDegrees = 45,
            todayUvIndexFactor = 5,
            todayHumidityDegrees = 60,
            todayWindDirection = "SSE",
            todayWindSpeed = 7,
            todayCoverageFactor = 24,
            todayRainFactor = 0,
            forecastIndex = 2
        ),
        TodayForecast(
            todayDate = OffsetDateTime.now().plusHours(7),
            todayDegrees = 30,
            todayRainfallPicture = WeatherIcon.RAINDROP,
            todayRainfall = 60,
            todayArrow = WeatherIcon.ARROW,
            todayPerceivedDegrees = 45,
            todayUvIndexFactor = 5,
            todayHumidityDegrees = 60,
            todayWindDirection = "SSE",
            todayWindSpeed = 7,
            todayCoverageFactor = 24,
            todayRainFactor = 0,
            forecastIndex = 3
        ),
        TodayForecast(
            todayDate = OffsetDateTime.now().plusHours(8),
            todayDegrees = 31,
            todayRainfallPicture = WeatherIcon.RAINDROP,
            todayRainfall = 40,
            todayArrow = WeatherIcon.ARROW,
            todayPerceivedDegrees = 45,
            todayUvIndexFactor = 5,
            todayHumidityDegrees = 60,
            todayWindDirection = "SSE",
            todayWindSpeed = 7,
            todayCoverageFactor = 24,
            todayRainFactor = 0,
            forecastIndex = 3
        ),
        TodayForecast(
            todayDate = OffsetDateTime.now().plusHours(9),
            todayDegrees = 32,
            todayRainfallPicture = WeatherIcon.RAINDROP,
            todayRainfall = 30,
            todayArrow = WeatherIcon.ARROW,
            todayPerceivedDegrees = 45,
            todayUvIndexFactor = 5,
            todayHumidityDegrees = 60,
            todayWindDirection = "SSE",
            todayWindSpeed = 7,
            todayCoverageFactor = 24,
            todayRainFactor = 0,
            forecastIndex = 3
        ),
        TodayForecast(
            todayDate = OffsetDateTime.now().plusHours(10),
            todayDegrees = 30,
            todayRainfallPicture = WeatherIcon.RAINDROP,
            todayRainfall = 20,
            todayArrow = WeatherIcon.ARROW,
            todayPerceivedDegrees = 45,
            todayUvIndexFactor = 5,
            todayHumidityDegrees = 60,
            todayWindDirection = "SSE",
            todayWindSpeed = 7,
            todayCoverageFactor = 24,
            todayRainFactor = 0,
            forecastIndex = 3
        ),
        TodayForecast(
            todayDate = OffsetDateTime.now().plusHours(11),
            todayDegrees = 29,
            todayRainfallPicture = WeatherIcon.RAINDROP,
            todayRainfall = 0,
            todayArrow = WeatherIcon.ARROW,
            todayPerceivedDegrees = 45,
            todayUvIndexFactor = 5,
            todayHumidityDegrees = 60,
            todayWindDirection = "SSE",
            todayWindSpeed = 7,
            todayCoverageFactor = 24,
            todayRainFactor = 0,
            forecastIndex = 1
        )
    )

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
}