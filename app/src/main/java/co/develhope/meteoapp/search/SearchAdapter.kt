package co.develhope.meteoapp.search

import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.CardSearchItemBinding
import co.develhope.meteoapp.databinding.RecentSearchItemBinding
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
            val regionName = place.country
            val formattedText = "${cityName}, $regionName"
            binding.searchItemCity.text = formattedText

            binding.searchItemCard.setOnClickListener {
                onPlaceClicked(place)
                val cityName = place.city
                val regionName = place.country
                val selectedPlace = "${cityName}, $regionName".trim().removeSuffix(",")
                Log.d("SelectedPlace", "Formatted: $selectedPlace")
                sharedPreferences.edit().putString("selected_place", selectedPlace).apply()
            }
        }
    }


    inner class RecentSearchViewHolder(private val binding: RecentSearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recentSearch: String) {
            binding.root

            binding.root.setOnClickListener {
                // Implementa l'azione quando un elemento di ricerca recente viene cliccato
                // ad esempio, puoi avviare una nuova ricerca con questo termine
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < placeList.size) {
            VIEW_TYPE_CITY
        } else {
            VIEW_TYPE_RECENT_SEARCH
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
                holder.bind(placeList[position])
            }

            is RecentSearchViewHolder -> {
                val recentSearch = placeList[position] as String
                holder.bind(recentSearch)
            }
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }
}