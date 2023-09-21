package co.develhope.meteoapp.today

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.TodayItemBinding
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import co.develhope.meteoapp.R

class TodayAdapter(val todayscreen: List<TodayData>) :
    RecyclerView.Adapter<TodayViewHolder>() {

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

        holder.onBind(model, position, openElementIndex) {
            if (position in openElementIndex) {
                openElementIndex.remove(position)
            } else {
                openElementIndex.add(position)
            }
            notifyItemChanged(position)
        }
    }
}