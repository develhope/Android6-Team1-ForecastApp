package co.develhope.meteoapp.today

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.TodayItemBinding
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import co.develhope.meteoapp.R

class TodayAdapter(val todayscreen: List<TodayData>) :
    RecyclerView.Adapter<TodayAdapter.TodayViewHolder>() {
    class TodayViewHolder(val binding: TodayItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    val openElementIndex = mutableListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {
        return TodayViewHolder(
            TodayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return todayscreen.size
    }

    override fun onBindViewHolder(holder: TodayViewHolder, position: Int) {
        val model = todayscreen[position]

        //recyclerveiw item elements
        holder.binding.todayDateItem.text = model.todayDate
        holder.binding.todayWeatherIconItem.setImageResource(R.drawable.sun)
        holder.binding.todayDegreesItem.text = model.todayDegrees
        holder.binding.todayRainfallPictureItem.setImageResource(R.drawable.raindrop)
        holder.binding.todayRainfallItem.text = model.todayRainfall
        holder.binding.todayArrowItem.setImageResource(R.drawable.arrow)

        //recyclerview cardview elements
        holder.binding.todayPerceivedDegreesItem.text = model.todayPerceivedDegrees
        holder.binding.todayUvIndexFactorItem.text = model.todayUvIndexFactor
        holder.binding.todayHumidityFactorItem.text = model.todayHumidityDegrees
        holder.binding.todayWindFactorItem.text = model.todayWindFactor
        holder.binding.todayCoverageFactorItem.text = model.todayCoverageFactor
        holder.binding.todayRainCmItem.text = model.todayRainFactor

        if (position in openElementIndex) {
            holder.binding.cardview.visibility = VISIBLE

            holder.binding.todayArrowItem.rotation = 180f

        } else {
            holder.binding.cardview.visibility = GONE

            holder.binding.todayArrowItem.rotation = 0f
        }

        holder.binding.constraintlayoutItem.setOnClickListener {

            if (position in openElementIndex) {
                openElementIndex.remove(position)
            } else {
                openElementIndex.add(position)
            }
            notifyItemChanged(position)
        }
    }
}