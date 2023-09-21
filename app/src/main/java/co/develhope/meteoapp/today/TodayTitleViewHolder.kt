package co.develhope.meteoapp.today

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.meteoapp.databinding.FragmentTodayTitleBinding

class TodayTitleViewHolder(val binding : FragmentTodayTitleBinding): ViewHolder(binding.root) {

    fun onBind(model: TodayData.TodayTitleData) {
        binding.todayLocation.text = model.todayTitleLocation
        binding.todayDateOfMonth.text = model.todayTitleDate
    }

}