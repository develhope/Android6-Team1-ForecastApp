package co.develhope.meteoapp.tomorrow.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.TomorrowItemBinding
import co.develhope.meteoapp.databinding.TomorrowItemTitleBinding
import co.develhope.meteoapp.tomorrow.model.TomorrowData
import co.develhope.meteoapp.tomorrow.model.TomorrowData.Companion.card
import co.develhope.meteoapp.tomorrow.model.TomorrowData.Companion.title
import co.develhope.meteoapp.tomorrow.viewholders.TitleViewHolder
import co.develhope.meteoapp.tomorrow.viewholders.TomorrowViewHolder

class TomorrowAdapter(val tomorrowList: List<TomorrowData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val indexOpenedItem = mutableListOf<Int>()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = tomorrowList[position]
        if (holder is TitleViewHolder) {
            holder.onBind(
                model = model as TomorrowData.TomorrowTitle
            )
        } else if (holder is TomorrowViewHolder) {
            holder.onBind(
                model = model as TomorrowData.TomorrowCard,
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
        return tomorrowList[position].type
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