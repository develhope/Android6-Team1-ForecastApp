package co.develhope.meteoapp.home.viewHolder

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.HomeSubtitleBinding
import co.develhope.meteoapp.home.data.HomeForecast

class HomeSubtitleViewHolder(private val binding: HomeSubtitleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HomeForecast.HomeSubtitle) {
        binding.homeSubtitle.text = item.textToShow

    }
}
