package co.develhope.meteoapp.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.HomeCardBinding
import co.develhope.meteoapp.databinding.HomeSubtitleBinding
import co.develhope.meteoapp.databinding.HomeTitleBinding
import co.develhope.meteoapp.home.data.HomeForecast
import co.develhope.meteoapp.home.data.HomeForecast.Companion.HomeDaysId
import co.develhope.meteoapp.home.data.HomeForecast.Companion.HomeSubtitleId
import co.develhope.meteoapp.home.data.HomeForecast.Companion.HomeTitleId
import co.develhope.meteoapp.home.data.HomeForecast.Companion.HomeTodayId
import co.develhope.meteoapp.home.viewHolder.HomeCardsViewHolder
import co.develhope.meteoapp.home.viewHolder.HomeSubtitleViewHolder
import co.develhope.meteoapp.home.viewHolder.HomeTitleViewHolder
import co.develhope.meteoapp.home.viewHolder.HomeTodayViewHolder

class HomeAdapter(
    private var list: List<HomeForecast>,
    private val onClick: (HomeForecast) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return list[position].id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("WeekAdapter", "viewType is $viewType")
        return when (viewType) {

            HomeTodayId -> HomeTodayViewHolder(
                HomeCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )


            HomeDaysId -> HomeCardsViewHolder(
                HomeCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            HomeTitleId -> HomeTitleViewHolder(
                HomeTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            HomeSubtitleId -> HomeSubtitleViewHolder(
                HomeSubtitleBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )


            else -> throw Exception("Invalid ViewHolder Type")
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]

        when (holder) {
            is HomeCardsViewHolder -> holder.bind(item as HomeForecast.HomeDays, onClick)
            is HomeTodayViewHolder -> holder.bind(item as HomeForecast.HomeToday, onClick)
            is HomeTitleViewHolder -> holder.bind(item as HomeForecast.HomeTitle)
            is HomeSubtitleViewHolder -> holder.bind(item as HomeForecast.HomeSubtitle)
            else -> throw Exception("Invalid ViewHolder Not Recognized")
        }
    }

    fun setNewList(newList: List<HomeForecast>){
        list = newList
        notifyDataSetChanged()
    }

}


