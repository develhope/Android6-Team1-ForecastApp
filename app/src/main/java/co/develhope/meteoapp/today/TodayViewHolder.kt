package co.develhope.meteoapp.today

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.TodayItemBinding

class TodayViewHolder(val binding : TodayItemBinding): ViewHolder(binding.root) {

    fun onBind(model: TodayData.TodayItemData, position: Int, openElementIndex: List<Int>, onClick: () -> Unit) {
        //recyclerveiw item elements
        binding.todayDateItem.text = model.todayDate
        binding.todayWeatherIconItem.setImageResource(R.drawable.sun)
        binding.todayDegreesItem.text = model.todayDegrees
        binding.todayRainfallPictureItem.setImageResource(R.drawable.raindrop)
        binding.todayRainfallItem.text = model.todayRainfall
        binding.todayArrowItem.setImageResource(R.drawable.arrow)

        //recyclerview cardview elements
        binding.todayPerceivedDegreesItem.text = model.todayPerceivedDegrees
        binding.todayUvIndexFactorItem.text = model.todayUvIndexFactor
        binding.todayHumidityFactorItem.text = model.todayHumidityDegrees
        binding.todayWindFactorItem.text = model.todayWindFactor
        binding.todayCoverageFactorItem.text = model.todayCoverageFactor
        binding.todayRainCmItem.text = model.todayRainFactor

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