package co.develhope.meteoapp.search

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R

class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cityNameTextView: TextView = itemView.findViewById(R.id.search_item_city)

    fun bind(searchData: SearchData) {
        cityNameTextView.text = searchData.name
    }
}