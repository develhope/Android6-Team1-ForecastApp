package co.develhope.meteoapp.today.model

import co.develhope.meteoapp.data.domain.TodayForecast
import org.threeten.bp.OffsetDateTime

sealed class TodayData(val type : Int) {
    data class TodayItemData(
        val forecast : TodayForecast
    ) : TodayData(item)

    data class TodayTitleData(
        val todayLocation: String,
        val todayTitleDate: OffsetDateTime
    ) : TodayData(title)

    companion object {
        const val item = 1
        const val title = 2
    }
}
//fun ImageView.setWeatherIcon(weatherIcon: TodayWeatherIcon) {
//    this.setImageResource(weatherIcon.image)
//}

