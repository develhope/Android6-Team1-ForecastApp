package co.develhope.meteoapp.data.domain

import org.threeten.bp.OffsetDateTime

data class TodayCardForecast(
    val time: OffsetDateTime,
    val weatherPicture: Int,
    val degrees: Int,
    val rainFactor: Int,
    val perceived: Int,
    val humidity: Int,
    val wind: Int,
    val coverage: Int,
    val rainHeight: Int
)
