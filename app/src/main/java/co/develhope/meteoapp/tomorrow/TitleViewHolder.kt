package co.develhope.meteoapp.tomorrow

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.TomorrowItemTitleBinding

class TitleViewHolder(val binding: TomorrowItemTitleBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: TomorrowTitleData) {

            binding.tomorrowPlace.text = model.place
            binding.tomorrowinfo.text = model.dayDate
        }
}