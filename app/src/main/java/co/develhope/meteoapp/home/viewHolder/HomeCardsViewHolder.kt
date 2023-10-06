package co.develhope.meteoapp.home.viewHolder

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domain.HomeForecast
import co.develhope.meteoapp.databinding.FragmentHomeListItemBinding
import org.threeten.bp.format.DateTimeFormatter
import java.time.OffsetDateTime
import java.util.Locale

class HomeCardsViewHolder(private val binding: FragmentHomeListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(item: HomeForecast.HomeSpecificDay, onClick: (HomeForecast) -> Unit) {
        val tomorrow = OffsetDateTime.now().plusDays(1)

        if (item.homeTodayDate.dayOfMonth == tomorrow.dayOfMonth) {
            binding.dayOfTheWeekTxt.text = binding.root.context.getString(R.string.tomorrowtxt)
        } else {
            binding.dayOfTheWeekTxt.text =
                item.homeTodayDate.format(DateTimeFormatter.ofPattern("EEE", Locale.ITALIAN))
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
        binding.dayOfMonthTxt.text = item.homeTodayDate.format(DateTimeFormatter.ofPattern("dd/MM"))

    }
}