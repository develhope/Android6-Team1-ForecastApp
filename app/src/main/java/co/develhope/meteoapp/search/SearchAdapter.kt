package co.develhope.meteoapp.search

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.CardSearchItemBinding
import co.develhope.meteoapp.domainmodel.Place

class SearchAdapter(
    private val placeList: List<Place>,
    private val onPlaceClicked: (Place) -> Unit,
    private val sharedPreferences: SharedPreferences
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
        fun bind(place: Place) {
            val cityName = place.city
            val regionName = place.region
            binding.searchItemCity.text =
                binding.root.context.getString(R.string.city_search, cityName, regionName)

            binding.searchItemCard.setOnClickListener {
                onPlaceClicked(place)
                sharedPreferences.edit().putString("selected_place", place.city).apply()
            }
        }
    }

    /*  inner class RecentSearchViewHolder(private val binding: RecentSearchItemBinding) :
          RecyclerView.ViewHolder(binding.root) {
          fun bind(recentSearch: SearchPlaceResult.RecentSearch) {
              binding.searchItem.text = binding.root.context.getString(R.string.recentSearch)
          }
      }*/

    override fun getItemViewType(position: Int): Int {
        //TODO to rewrite
        return VIEW_TYPE_CITY

        /*return when (recentSearchList[position]) {
                is SearchPlaceResult.Success -> VIEW_TYPE_CITY
                is SearchPlaceResult.RecentSearch -> VIEW_TYPE_RECENT_SEARCH
                else -> throw IllegalArgumentException("Invalid ViewHolder Type")
            }*/
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

            /*  VIEW_TYPE_RECENT_SEARCH -> RecentSearchViewHolder(
                  RecentSearchItemBinding.inflate(
                      LayoutInflater.from(parent.context),
                      parent,
                      false
                  )
              )*/

            else -> throw IllegalArgumentException("Invalid ViewHolder Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CityViewHolder -> {
                holder.bind(placeList[position])
            }

            /*  is RecentSearchViewHolder -> {
              }*/
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }
}