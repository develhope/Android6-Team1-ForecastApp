package co.develhope.meteoapp.search

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.domainmodel.Place
import co.develhope.meteoapp.domainmodel.result.EventActionResult

class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cityNameTextView: TextView = itemView.findViewById(R.id.search_item_city)

    fun bind(place: Place) {
        cityNameTextView.text = place.city
    }
}
sealed class Search {
    data class SearchPlace(val city: EventActionResult) : Search()

    object RecentSearch : Search()
}
