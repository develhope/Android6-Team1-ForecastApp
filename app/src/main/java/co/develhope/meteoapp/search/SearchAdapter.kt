package co.develhope.meteoapp.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.CardSearchItemBinding
import co.develhope.meteoapp.databinding.RecentSearchItemBinding

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

    inner class CityViewHolder(private val binding: CardSearchItemBinding) : RecyclerView.ViewHolder(binding.root) {

        // TODO: DA MODIFICARE CON LA RISPOSTA DELL'API
        fun bind(newCityName: SearchData, position: Int) {
            binding.searchItemCard = newCityName.name.text
    }

    inner class RecentSearchViewHolder(binding: RecentSearchItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun getItemViewType(position: Int): Int {
        return if (position < cityList.size) {
            VIEW_TYPE_CITY
        } else {
            VIEW_TYPE_RECENT_SEARCH
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_CITY -> CityViewHolder(CardSearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

            VIEW_TYPE_RECENT_SEARCH -> RecentSearchViewHolder(RecentSearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid ViewHolder Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CityViewHolder -> holder.bind
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