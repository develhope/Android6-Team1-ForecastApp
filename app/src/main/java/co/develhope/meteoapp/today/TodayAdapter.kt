package co.develhope.meteoapp.today

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.TodayItemBinding
import android.view.LayoutInflater
class TodayAdapter(val todayscreen: List<TodayData>) :
    RecyclerView.Adapter<TodayAdapter.TodayViewHolder>() {
    class TodayViewHolder(val binding: TodayItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {
        return TodayViewHolder(
            TodayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return todayscreen.size    }

    override fun onBindViewHolder(holder: TodayViewHolder, position: Int) {
        val model = todayscreen[position]
        holder.binding.ora.text = model.
    }


}