package co.develhope.meteoapp.home.viewHolder

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domain.getWeatherIconBasedOnId
import co.develhope.meteoapp.data.domain.setWeatherIcon
import co.develhope.meteoapp.databinding.HomeCardBinding
import co.develhope.meteoapp.home.data.HomeForecast
import org.threeten.bp.format.DateTimeFormatter

class HomeTodayViewHolder(private val binding: HomeCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: HomeForecast.HomeToday, onClick: (HomeForecast) -> Unit) {
        binding.dayOfTheWeekTxt.text = binding.root.context.getString(R.string.title_oggi)
        binding.dayOfMonthTxt.text = item.date.format(DateTimeFormatter.ofPattern("dd/MM"))
        binding.homeMinPerceivedNum.text = item.minTemperature.toString()
        binding.homeMaxPerceivedNum.text = item.maxTemperature.toString()
        binding.homeImgWeather.setWeatherIcon(getWeatherIconBasedOnId(item.weatherIcon))
        binding.homePrecipitationNum.text = item.precipitation.toString()
        binding.homeWindNum.text = item.windSpeed.toString()
        binding.root.setOnClickListener {
            onClick(item)
            binding.root.findNavController().navigate(R.id.home_screen_to_today)


        }
    }
}