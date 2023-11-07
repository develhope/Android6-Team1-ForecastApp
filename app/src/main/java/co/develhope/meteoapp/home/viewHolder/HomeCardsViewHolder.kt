package co.develhope.meteoapp.home.viewHolder

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domain.getWeatherIconBasedOnId
import co.develhope.meteoapp.data.domain.setWeatherIcon
import co.develhope.meteoapp.databinding.HomeCardBinding
import co.develhope.meteoapp.home.data.HomeForecast
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.Locale

class HomeCardsViewHolder(private val binding: HomeCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: HomeForecast.HomeDays, onClick: (HomeForecast) -> Unit) {
        val today = OffsetDateTime.now()
        val tomorrow = OffsetDateTime.now().plusDays(1)

        when (item.date.dayOfMonth) {
            today.dayOfMonth -> {
                binding.dayOfTheWeekTxt.text = binding.root.context.getString(R.string.title_oggi)
            }

            tomorrow.dayOfMonth -> {
                binding.dayOfTheWeekTxt.text = binding.root.context.getString(R.string.tomorrowtxt)
            }

            else -> {
                binding.dayOfTheWeekTxt.text =
                    item.date.format(DateTimeFormatter.ofPattern("EEEE", Locale.ITALIAN))
                        .replaceFirstChar { it.uppercase() }
            }
        }
        binding.dayOfMonthTxt.text = item.date.format(DateTimeFormatter.ofPattern("dd/MM"))
        binding.homeMinPerceivedNum.text = item.minTemperature.toString()
        binding.homeMaxPerceivedNum.text = item.maxTemperature.toString()
        binding.homeImgWeather.setWeatherIcon(getWeatherIconBasedOnId(item.weatherIcon))
        binding.homePrecipitationNum.text = item.precipitation.toString()
        binding.homeWindNum.text = item.windSpeed.toString()
        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}