package co.develhope.meteoapp.home.viewHolder

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.data.domain.HomeForecast
import co.develhope.meteoapp.databinding.HomePlaceBinding

class HomeTitleViewHolder(private val binding: HomePlaceBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HomeForecast.HomeTitle) {
        binding.homePlaceTitle.text = item.homePlace
    }
}