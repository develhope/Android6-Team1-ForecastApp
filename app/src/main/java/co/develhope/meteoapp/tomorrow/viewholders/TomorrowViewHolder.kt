package co.develhope.meteoapp.tomorrow.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.data.domain.getWeatherIconBasedOnId
import co.develhope.meteoapp.data.domain.setWeatherIcon
import co.develhope.meteoapp.databinding.TomorrowItemBinding
import co.develhope.meteoapp.tomorrow.model.TomorrowData
import org.threeten.bp.format.DateTimeFormatter


class TomorrowViewHolder(val binding: TomorrowItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(
        model: TomorrowData.TomorrowCard,
        position: Int,
        indexOpenedItem: MutableList<Int>,
        onClick: () -> Unit
    ) {
        binding.itemOur.text =
            model.tomorrowForecast.tomorrowDate.format(DateTimeFormatter.ofPattern("HH:mm"))
        binding.itemimg.setWeatherIcon(getWeatherIconBasedOnId(model.tomorrowForecast.forecastIndex))
        binding.tomorrowTemp.text = "${model.tomorrowForecast.tomorrowDegrees}°"
        binding.tomorrowPrecipitation.text = "${model.tomorrowForecast.tomorrowRainfall}%"
        //cardview
        binding.percepitaNum.text = "${model.tomorrowForecast.tomorrowPerceivedDegrees}°"
        binding.Uvindex.text = "${model.tomorrowForecast.tomorrowUvIndexFactor}/10"
        binding.umiditaNum.text = "${model.tomorrowForecast.tomorrowHumidityDegrees}%"
        binding.ventoNum.text =
            "${model.tomorrowForecast.tomorrowWindDirection} ${model.tomorrowForecast.tomorrowWindSpeed}km/h"
        binding.coperturapercent.text = "${model.tomorrowForecast.tomorrowCoverageFactor}%"
        binding.rainpercent.text = "${model.tomorrowForecast.tomorrowRainFactor}cm"

        if (position in indexOpenedItem) {
            binding.cardview.visibility = View.VISIBLE
            binding.tomorrowFreccia.rotation = 180f
        } else {
            binding.cardview.visibility = View.GONE
            binding.tomorrowFreccia.rotation = 0f
        }
        binding.itemLayout.setOnClickListener {
            onClick()
        }
    }
}