package co.develhope.meteoapp.today

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.TodayItemBinding
import android.view.LayoutInflater
import android.view.View
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
        holder.binding.ora.text = model.ora
        holder.binding.immaginesole.setImageResource(R.drawable.sun)
        holder.binding.gradi.text = model.gradi
        holder.binding.immaginegoccia.setImageResource(R.drawable.raindrop)
        holder.binding.precipitazioni.text = model.precipitazioni
        holder.binding.freccia.setImageResource(R.drawable.arrow)

        //recyclerview cardview elements
        holder.binding.gradi45.text = model.gradi45
        holder.binding.indice510.text = model.indice510
        holder.binding.umiditagradi.text = model.umiditagradi
        holder.binding.ventosse.text = model.ventosse
        holder.binding.coperturagradi.text = model.coperturagradi
        holder.binding.pioggiacm.text = model.pioggiacm

        if (position in openElementIndex) {
            holder.binding.cardview.visibility = VISIBLE

            holder.binding.freccia.rotation = 180f

        } else {
            holder.binding.cardview.visibility = GONE

            holder.binding.freccia.rotation = 0f
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