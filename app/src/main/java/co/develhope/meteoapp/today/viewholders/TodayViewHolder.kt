package co.develhope.meteoapp.today.viewholders

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.meteoapp.data.domain.getWeatherIconBasedOnId
import co.develhope.meteoapp.data.domain.setWeatherIcon
import co.develhope.meteoapp.databinding.TodayItemBinding
import co.develhope.meteoapp.today.model.TodayData
import java.time.format.DateTimeFormatter

class TodayViewHolder(val binding : TodayItemBinding): ViewHolder(binding.root) {

    @RequiresApi(Build.VERSION_CODES.O)
    fun onBind(model: TodayData.TodayItemData, position: Int, openElementIndex: List<Int>, onClick: () -> Unit) {
        //recyclerveiw item elements
        binding.todayDateItem.text = model.forecast.todayDate.format(DateTimeFormatter.ofPattern("HH:mm"))
        binding.todayWeatherIconItem.setWeatherIcon(getWeatherIconBasedOnId(1))
        binding.todayDegreesItem.text = "${model.forecast.todayDegrees}°"
        binding.todayRainfallPictureItem.setWeatherIcon(getWeatherIconBasedOnId(4))
        binding.todayRainfallItem.text = "${model.forecast.todayRainfall}%"
        binding.todayArrowItem.setWeatherIcon(getWeatherIconBasedOnId(5))

        //recyclerview cardview elements
        binding.todayPerceivedDegreesItem.text = "${model.forecast.todayPerceivedDegrees}°"
        binding.todayUvIndexFactorItem.text = "${model.forecast.todayUvIndexFactor}/10"
        binding.todayHumidityFactorItem.text = "${model.forecast.todayHumidityDegrees}%"
        binding.todayWindFactorItem.text = "${model.forecast.todayWindSpeed} ${model.forecast.todayWindDirection}km/h"
        binding.todayCoverageFactorItem.text = "${model.forecast.todayCoverageFactor}%"
        binding.todayRainCmItem.text = "${model.forecast.todayRainFactor}cm"


        //Cardview Visibility and Animation
        if (position in openElementIndex) {
            binding.cardview.visibility = View.VISIBLE

            binding.todayArrowItem.rotation = 180f

        } else {
            binding.cardview.visibility = View.GONE

            binding.todayArrowItem.rotation = 0f
        }

        binding.constraintlayoutItem.setOnClickListener {
            onClick()
        }
    }
}