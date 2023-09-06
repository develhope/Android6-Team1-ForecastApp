package co.develhope.meteoapp


import android.view.LayoutInflater
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
        //cardhview
        holder.binding.percipita.text = model.percepita
        holder.binding.Indiceuv.text = model.indiceuv
        holder.binding.percepitaNum.text = model.percepitaNum
        holder.binding.Uvindex.text = model.Uvindex
        holder.binding.umidita.text = model.umidita
        holder.binding.umiditaNum.text = model.umiditaNum
        holder.binding.vento.text = model.vento
        holder.binding.ventoNum.text = model.ventoNum
        holder.binding.copertura.text = model.copertura
        holder.binding.coperturapercent.text = model.coperturaNum
        holder.binding.rain.text = model.pioggiaCard
        holder.binding.rainpercent.text = model.pioggiaCardNum







    }
}