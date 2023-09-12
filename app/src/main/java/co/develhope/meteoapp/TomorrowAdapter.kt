package co.develhope.meteoapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.TomorrowItemBinding

class TomorrowAdapter(val tomorrowList: List<TomorrowData>) :
    RecyclerView.Adapter<TomorrowAdapter.TomorrowViewHolder>() {
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
        holder.binding.itemLayout.setOnClickListener {
            holder.binding.tomorrowFreccia.animate().apply {
                duration = 500
                rotationBy(180f)

                if (holder.binding.cardview.visibility == View.GONE) {
                    holder.binding.cardview.visibility = View.VISIBLE
                } else {
                    holder.binding.cardview.visibility = View.GONE
                }


            }
        }
    }
}