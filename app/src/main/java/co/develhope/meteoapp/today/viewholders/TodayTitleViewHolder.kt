package co.develhope.meteoapp.today.viewholders

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.meteoapp.databinding.FragmentTodayTitleBinding
import co.develhope.meteoapp.today.model.TodayData
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class TodayTitleViewHolder(private val binding: FragmentTodayTitleBinding) :
    ViewHolder(binding.root) {

    fun stringsToCapitalize(input: String): String {
        return input.split(" ").joinToString(" ") { it.capitalize() }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onBind(model: TodayData.TodayTitleData) {

        val currentDate = LocalDate.now()
        val formattedDate = stringsToCapitalize(
            currentDate.format(
                DateTimeFormatter.ofPattern(
                    "EEEE d MMMM",
                    Locale.ITALIAN
                )
            )
        )

        binding.todayTitleCity.text = model.todayLocation
        binding.todayDateOfMonth.text = formattedDate
    }

}