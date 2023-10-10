package co.develhope.meteoapp.home.viewHolder

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.HomeTitleBinding
import co.develhope.meteoapp.home.data.HomeForecast

class HomeTitleViewHolder(private val binding: HomeTitleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HomeForecast.HomeTitle) {
        binding.homePlaceTitle.text = item.textToShow
    }
}