package co.develhope.meteoapp.search

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.CardSearchItemBinding
import co.develhope.meteoapp.databinding.RecentSearchItemBinding
import co.develhope.meteoapp.domainmodel.result.EventActionResult
import co.develhope.meteoapp.dto.CityInfo


class SearchAdapter(
    private val myItemClickListener: OnItemClickListener?,
    private val recentSearchList: List<EventActionResult>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_CITY = 1
        private const val VIEW_TYPE_RECENT_SEARCH = 2
    }

    interface OnItemClickListener {
        fun onItemClick(cityName: String)
    }

    inner class CityViewHolder(private val binding: CardSearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val cityTextView: TextView = binding.root.findViewById(R.id.search_item_city)

        fun bind(newCityInfo: EventActionResult.Success) {
            val cityName = newCityInfo.data.results[0].city
            val regionName = newCityInfo.data.results[0].region
            binding.searchItemCity.text =
                binding.root.context.getString(R.string.city_search, cityName, regionName)
            binding.searchItemCard.setOnClickListener() {
                myItemClickListener?.onItemClick(cityName)
            }
        }
    }

    inner class RecentSearchViewHolder(private val binding: RecentSearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recentSearch: CityInfo) {
            binding.searchItem.text = binding.root.context.getString(R.string.recentSearch)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (recentSearchList[position]) {
            is EventActionResult.Success -> VIEW_TYPE_CITY
            is EventActionResult.RecentSearch -> VIEW_TYPE_RECENT_SEARCH
            else -> throw IllegalArgumentException("Invalid ViewHolder Type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_CITY -> CityViewHolder(
                CardSearchItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            VIEW_TYPE_RECENT_SEARCH -> RecentSearchViewHolder(
                RecentSearchItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException("Invalid ViewHolder Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CityViewHolder -> {
                if (position < recentSearchList.size) {
                    val cityInfo = recentSearchList[position]
                    if (cityInfo is EventActionResult.Success) {
                        val cityName = cityInfo.data.results[0].city
                        holder.bind(cityInfo)
                        holder.itemView.setOnClickListener {
                            myItemClickListener?.onItemClick(cityName)
                        }
                    }
                }
            }

            is RecentSearchViewHolder -> {
                // TODO: Gestire binding e l'evento di click per gli elementi di recentSearch se necessario.
            }
        }
    }

    override fun getItemCount(): Int {
        return recentSearchList.size
    }
}