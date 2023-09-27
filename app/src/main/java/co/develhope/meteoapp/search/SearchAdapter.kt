package co.develhope.meteoapp.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R

class SearchAdapter(private val cityList: List<SearchData>) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityNameTextView: TextView = itemView.findViewById(R.id.search_item_city)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val city = cityList[position]
        holder.cityNameTextView.text = city.name


        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(city)
        }
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    interface OnItemClickListener {
        fun onItemClick(searchData: SearchData)
    }
}
