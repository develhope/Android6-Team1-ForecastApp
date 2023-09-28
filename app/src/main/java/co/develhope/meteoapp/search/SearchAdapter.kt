package co.develhope.meteoapp.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R

class SearchAdapter(
    private val cityList: MutableList<String>,
    private val recentSearchList: List<SearchData>,
    private val onItemClickListener: OnItemClickListener?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_CITY = 1
        private const val VIEW_TYPE_RECENT_SEARCH = 2
    }

    interface OnItemClickListener {
        fun onItemClick(searchData: SearchData)
    }

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityNameTextView: TextView = itemView.findViewById(R.id.search_item_city)
    }

    inner class RecentSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemViewType(position: Int): Int {
        return if (position < cityList.size) {
            VIEW_TYPE_CITY
        } else {
            VIEW_TYPE_RECENT_SEARCH
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_CITY -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.city_item, parent, false)
                CityViewHolder(view)
            }

            VIEW_TYPE_RECENT_SEARCH -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recent_search_item, parent, false)
                RecentSearchViewHolder(view)
            }

            else -> throw IllegalArgumentException("Invalid ViewHolder Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_CITY -> {
                val cityHolder = holder as CityViewHolder
                val city = cityList[position]
                cityHolder.cityNameTextView.text = city
            }

            VIEW_TYPE_RECENT_SEARCH -> {
                val recentSearchHolder = holder as RecentSearchViewHolder
                recentSearchHolder.itemView.setOnClickListener {
                    val recentSearch = recentSearchList[position - cityList.size]
                    onItemClickListener?.onItemClick(recentSearch)
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return cityList.size + recentSearchList.size
    }
}