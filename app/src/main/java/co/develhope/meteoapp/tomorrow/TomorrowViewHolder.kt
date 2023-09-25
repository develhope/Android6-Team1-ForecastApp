package co.develhope.meteoapp.tomorrow

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.TomorrowItemBinding

class TomorrowViewHolder(val binding: TomorrowItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(
        model: TomorrowData,
        position: Int,
        indexOpenedItem: List<Int>,
        onClick: () -> Unit
    ) {
        binding.itemOur.text = model.item_our
        binding.itemimg.setImageResource(R.drawable.fluent_emoji_crescent_moon)
        binding.tomorrowTemp.text = model.tomorrow_temp
        binding.tomorrowPrecipitation.text = model.tomorrow_precipitation
        binding.tomorrowPrecipitationimg.setImageResource(R.drawable.fluent_drop_16_filled)
        binding.tomorrowFreccia.setImageResource(R.drawable.freccia)
        //cardview
        binding.percepitaNum.text = model.perceived_num
        binding.Uvindex.text = model.uv_index
        binding.umiditaNum.text = model.umidity_num
        binding.ventoNum.text = model.wind_num
        binding.coperturapercent.text = model.coverage_num
        binding.rainpercent.text = model.rain_card_num

        if (position in indexOpenedItem) {
            binding.cardview.visibility = View.VISIBLE
            binding.tomorrowFreccia.rotation = 180f
        } else {
            binding.cardview.visibility = View.GONE
            binding.tomorrowFreccia.rotation = 0f
        }
        binding.itemLayout.setOnClickListener {
            onClick()
        }
    }
}