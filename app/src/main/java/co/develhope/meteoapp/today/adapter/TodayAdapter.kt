package co.develhope.meteoapp.today.adapter

import android.os.Build
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.TodayItemBinding
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.meteoapp.databinding.FragmentTodayTitleBinding
import co.develhope.meteoapp.today.model.TodayData
import co.develhope.meteoapp.today.model.TodayData.Companion.item
import co.develhope.meteoapp.today.model.TodayData.Companion.title
import co.develhope.meteoapp.today.viewholders.TodayTitleViewHolder
import co.develhope.meteoapp.today.viewholders.TodayViewHolder

class TodayAdapter(val todayscreen: List<TodayData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val openElementIndex = mutableListOf<Int>()

    override fun getItemViewType(position: Int): Int {
        return todayscreen[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            item -> TodayViewHolder(
                TodayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            title -> TodayTitleViewHolder(
                FragmentTodayTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw Exception("Invalid View Holder")
        }
    }

    override fun getItemCount(): Int {
        return todayscreen.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = todayscreen[position]

        when (holder) {

            is TodayViewHolder -> holder.onBind(
                model as TodayData.TodayItemData,
                position,
                openElementIndex
            ) {
                if (position in openElementIndex) {
                    openElementIndex.remove(position)
                } else {
                    openElementIndex.add(position)
                }
                notifyItemChanged(position)
            }

            is TodayTitleViewHolder -> holder.onBind(model as TodayData.TodayTitleData)
        }
    }
}