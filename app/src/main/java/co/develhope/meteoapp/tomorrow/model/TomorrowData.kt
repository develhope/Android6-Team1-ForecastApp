package co.develhope.meteoapp.tomorrow.model

import co.develhope.meteoapp.data.domain.TomorrowForecast
import org.threeten.bp.OffsetDateTime

sealed class TomorrowData(val type: Int) {

    data class TomorrowTitle(
        val tomorrowLocation: String,
        val tomorrowTitleDate: OffsetDateTime
    ) : TomorrowData(title)


    data class TomorrowCard(
        val tomorrowForecast: TomorrowForecast
    ) : TomorrowData(card)

    companion object {
        const val title = 1
        const val card = 2
    }


}
