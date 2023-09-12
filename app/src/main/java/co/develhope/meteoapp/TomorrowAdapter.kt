package co.develhope.meteoapp


import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.TomorrowItemBinding

class TomorrowAdapter(val tomorrowList: List<TomorrowData>) :
    RecyclerView.Adapter<TomorrowAdapter.TomorrowViewHolder>() {

    val indexOpenedItem = mutableListOf<Int>()

    class TomorrowViewHolder(val binding: TomorrowItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TomorrowViewHolder {
        return TomorrowViewHolder(
            TomorrowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return tomorrowList.size

    }

    override fun onBindViewHolder(holder: TomorrowViewHolder, position: Int) {
        val model = tomorrowList[position]
        holder.binding.itemOur.text = model.item_our
        holder.binding.itemimg.setImageResource(R.drawable.fluent_emoji_crescent_moon)
        holder.binding.tomorrowTemp.text = model.tomorrow_temp
        holder.binding.tomorrowPrecipitation.text = model.tomorrow_precipitation
        holder.binding.tomorrowPrecipitationimg.setImageResource(R.drawable.fluent_drop_16_filled)
        holder.binding.tomorrowFreccia.setImageResource(R.drawable.freccia)
        //cardview
        holder.binding.percepitaNum.text = model.percepitaNum
        holder.binding.Uvindex.text = model.Uvindex
        holder.binding.umiditaNum.text = model.umiditaNum
        holder.binding.ventoNum.text = model.ventoNum
        holder.binding.coperturapercent.text = model.coperturaNum
        holder.binding.rainpercent.text = model.pioggiaCardNum

        if (position in indexOpenedItem) {
            holder.binding.cardview.visibility = VISIBLE

            holder.binding.tomorrowFreccia.rotation = 180f

        } else {
            holder.binding.cardview.visibility = GONE
            holder.binding.tomorrowFreccia.rotation = 0f
        }

        holder.binding.itemLayout.setOnClickListener {
            if( position in indexOpenedItem){
                indexOpenedItem.remove(position)
            }else{
                indexOpenedItem.add(position)
            }
            notifyItemChanged(position)
        }
    }
}