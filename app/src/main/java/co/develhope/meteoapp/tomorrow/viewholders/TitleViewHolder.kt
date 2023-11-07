package co.develhope.meteoapp.tomorrow.viewholders

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.TomorrowItemTitleBinding
import co.develhope.meteoapp.tomorrow.model.TomorrowData
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.Locale

class TitleViewHolder(private val binding: TomorrowItemTitleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private fun capitalizer(input: String): String {
        return input
            .split(" ")
            .joinToString(" ") { word ->
                word.replaceFirstChar { it.titlecase(Locale.ROOT) }
            }
    }

    fun onBind(model: TomorrowData.TomorrowTitle) {
        val fullDate = capitalizer(
            model.tomorrowTitleDate.format(
                DateTimeFormatter.ofPattern(
                    "EEEE d MMMM",
                    Locale.ITALIAN
                )
            )
        )

        val dayAndMonth = capitalizer(
            model.tomorrowTitleDate.format(
                DateTimeFormatter.ofPattern(
                    "EEEE d MMMM",
                    Locale.ITALIAN
                )
            )
        )

        val formattedWeekDay = capitalizer(
            model.tomorrowTitleDate.format(
                DateTimeFormatter.ofPattern(
                    "EEEE",
                    Locale.ITALIAN
                )
            )
        )

        val tomorrow = OffsetDateTime.now().plusDays(1)

        val weekDay = model.tomorrowTitleDate.dayOfMonth

        if (weekDay == tomorrow.dayOfMonth) {
            binding.tomorrowtest.text = binding.root.context.getString(R.string.tomorrowtxt)
            binding.tomorrowinfo.text = fullDate
        } else {
            binding.tomorrowtest.text = formattedWeekDay
            binding.tomorrowinfo.text = dayAndMonth
        }

        binding.tomorrowPlace.text = model.tomorrowLocation
//        binding.todayConditionTv.text = Data.weatherCodetoCondition(Data.getSavedCondition()!!)
    }
}