package co.develhope.meteoapp.tomorrow


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.TomorrowItemBinding
import co.develhope.meteoapp.databinding.TomorrowItemTitleBinding
import co.develhope.meteoapp.tomorrow.TomorrowAdapterData.Companion.card
import co.develhope.meteoapp.tomorrow.TomorrowAdapterData.Companion.title

class TomorrowAdapter(val tomorrowList: List<TomorrowAdapterData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val indexOpenedItem = mutableListOf<Int>()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = tomorrowList[position]
        if (holder is TitleViewHolder) {
            holder.onBind(
                model = (model as TomorrowAdapterData.Title).model
            )
        } else if (holder is TomorrowViewHolder) {
            holder.onBind(
                model = (model as TomorrowAdapterData.Card).model,
                position = position,
                indexOpenedItem = indexOpenedItem,
                onClick = {

                    if (position in indexOpenedItem) {
                        indexOpenedItem.remove(position)
                    } else {
                        indexOpenedItem.add(position)
                    }
                    notifyItemChanged(position)
                }
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return tomorrowList[position].identifier
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == title) {
            TitleViewHolder(
                TomorrowItemTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else if (viewType == card) {
            TomorrowViewHolder(
                TomorrowItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            throw Exception("Invalid ViewType")
        }


    }

    override fun getItemCount(): Int {
        return tomorrowList.size

    }


}