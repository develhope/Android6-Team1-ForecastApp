package co.develhope.meteoapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import co.develhope.meteoapp.data.domain.TodayForecast
import co.develhope.meteoapp.data.domain.TomorrowForecast
import co.develhope.meteoapp.data.domain.WeatherIcon
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
                    "70%",
                    11,
                    1,
                    7,
                    1
                )
            ),
        )
    }
}