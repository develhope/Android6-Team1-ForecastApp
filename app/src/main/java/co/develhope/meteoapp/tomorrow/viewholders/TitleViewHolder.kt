package co.develhope.meteoapp.tomorrow.viewholders

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.TomorrowItemTitleBinding
import co.develhope.meteoapp.tomorrow.model.TomorrowData
import org.threeten.bp.LocalDate
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
        val currentDate = LocalDate.now().plusDays(1)
        val formattedDate = capitalizer(
            currentDate.format(
                DateTimeFormatter.ofPattern(
                    "EEEE d MMMM",
                    Locale.ITALIAN
                )
            )
        )
        binding.tomorrowPlace.text = model.tomorrowLocation
        binding.tomorrowinfo.text = formattedDate
    }
}