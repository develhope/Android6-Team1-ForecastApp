package co.develhope.meteoapp.tomorrow.viewholders

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.TomorrowItemTitleBinding
import co.develhope.meteoapp.tomorrow.model.TomorrowData
import org.threeten.bp.LocalDate
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.Locale

class TitleViewHolder(private val binding: TomorrowItemTitleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun capitalizer(input: String): String {
        return input.split(" ").joinToString(" ") {
            it.capitalize()
        }
    }

    fun onBind(model: TomorrowData.TomorrowTitle) {
        val currentDate = Data.getDate()

        val fullDate = capitalizer(
            currentDate!!.format(
                DateTimeFormatter.ofPattern(
                    "EEEE d MMMM",
                    Locale.ITALIAN
                )
            )
        )

        val dayAndMonth = capitalizer(
            currentDate.format(
                DateTimeFormatter.ofPattern(
                    "d MMMM",
                    Locale.ITALIAN
                )
            )
        )

        val formattedWeekDay = capitalizer(currentDate.format(DateTimeFormatter.ofPattern("EEEE", Locale.ITALIAN)))

        val tomorrow = OffsetDateTime.now().plusDays(1)

        val weekDay = currentDate.dayOfMonth

        if (weekDay == tomorrow.dayOfMonth) {
            binding.tomorrowtest.text = binding.root.context.getString(R.string.tomorrowtxt)
            binding.tomorrowinfo.text = fullDate
        } else{
            binding.tomorrowtest.text = formattedWeekDay
            binding.tomorrowinfo.text = dayAndMonth
        }

//        binding.todayLocationTv.text = model.todayLocation
//        binding.todayConditionTv.text = Data.weatherCodetoCondition(Data.getSavedCondition()!!)
    }
}