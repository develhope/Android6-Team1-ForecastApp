package co.develhope.meteoapp.data.local

import org.threeten.bp.OffsetDateTime


class WeeklyDataLocal() : ArrayList<WeeklyDataLocal.HomeDataLocal>() {
    data class HomeDataLocal(
        val date: OffsetDateTime,
        val minTemperature: Double?,
        val maxTemperature: Double?,
        val weatherIcon: Int?,
        val precipitation: Double?,
        val windSpeed: Double?,
    )
}