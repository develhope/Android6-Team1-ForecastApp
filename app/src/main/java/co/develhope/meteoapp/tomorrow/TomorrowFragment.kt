package co.develhope.meteoapp.tomorrow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.FragmentTomorrowBinding

class TomorrowFragment : Fragment() {

    private var _binding: FragmentTomorrowBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTomorrowBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.dayList.adapter = TomorrowAdapter(
            listOf(
                TomorrowAdapterData.Title(
                    TomorrowTitleData(
                        "Palermo, Sicilia","Lunedi 11 settembre"
                    )
                ),
                TomorrowAdapterData.Card(
                    TomorrowData(
                        "00:00", R.drawable.fluent_emoji_crescent_moon, "15°",
                        R.drawable.fluent_drop_16_filled, "60%",
                        R.drawable.freccia, "Percepita", "indice UV",
                        "14°", "1/10", "Umidità", "Vento", "70%",
                        "11 km/h",
                        "Copertura", "Pioggia", "7%", "0cm"
                    )
                ),
                TomorrowAdapterData.Card(

                    TomorrowData(
                        "01:00", R.drawable.fluent_emoji_crescent_moon, "15°",
                        R.drawable.fluent_drop_16_filled, "60%",
                        R.drawable.freccia, "Percepita", "indice UV",
                        "16°", "1/10", "Umidità", "Vento", "70%",
                        "12 km/h",
                        "Copertura", "Pioggia", "7%", "0cm"
                    )
                ),
                TomorrowAdapterData.Card(

                    TomorrowData(
                        "02:00", R.drawable.fluent_emoji_crescent_moon, "15°",
                        R.drawable.fluent_drop_16_filled, "60%",
                        R.drawable.freccia, "Percepita", "indice UV",
                        "12°", "1/10", "Umidità", "Vento", "70%",
                        "12 km/h",
                        "Copertura", "Pioggia", "7%", "0cm"
                    )
                ),
                TomorrowAdapterData.Card(

                    TomorrowData(
                        "03:00", R.drawable.fluent_emoji_crescent_moon, "15°",
                        R.drawable.fluent_drop_16_filled, "60%",
                        R.drawable.freccia, "Percepita", "indice UV",
                        "14°", "1/10", "Umidità", "Vento", "70%",
                        "12 km/h",
                        "Copertura", "Pioggia", "7%", "0cm"
                    )
                ),
                TomorrowAdapterData.Card(

                    TomorrowData(
                        "04:00", R.drawable.fluent_emoji_crescent_moon, "15°",
                        R.drawable.fluent_drop_16_filled, "60%",
                        R.drawable.freccia, "Percepita", "indice UV",
                        "16°", "1/10", "Umidità", "Vento", "70%",
                        "12 km/h",
                        "Copertura", "Pioggia", "7%", "0cm"
                    )
                ),
                TomorrowAdapterData.Card(

                    TomorrowData(
                        "05:00", R.drawable.sun_cloud, "15°",
                        R.drawable.fluent_drop_16_filled, "60%",
                        R.drawable.freccia, "Percepita", "indice UV",
                        "18°", "1/10", "Umidità", "Vento", "60%",
                        "12 km/h",
                        "Copertura", "Pioggia", "7%", "0cm"
                    )
                ),
                TomorrowAdapterData.Card(

                    TomorrowData(
                        "06:00", R.drawable.sun_cloud, "15°",
                        R.drawable.fluent_drop_16_filled, "60%",
                        R.drawable.freccia, "Percepita", "indice UV",
                        "18°", "1/10", "Umidità", "Vento", "50%",
                        "12 km/h",
                        "Copertura", "Pioggia", "7%", "0cm"
                    )
                ),
                TomorrowAdapterData.Card(

                    TomorrowData(
                        "07:00", R.drawable.suns, "15°",
                        R.drawable.fluent_drop_16_filled, "60%",
                        R.drawable.freccia, "Percepita", "indice UV",
                        "20°", "1/10", "Umidità", "Vento", "40%",
                        "12 km/h",
                        "Copertura", "Pioggia", "7%", "0cm"
                    )
                ),
                TomorrowAdapterData.Card(

                    TomorrowData(
                        "08:00", R.drawable.suns, "15°",
                        R.drawable.fluent_drop_16_filled, "60%",
                        R.drawable.freccia, "Percepita", "indice UV",
                        "22°", "1/10", "Umidità", "Vento", "30%",
                        "12 km/h",
                        "Copertura", "Pioggia", "7%", "0cm"
                    )
                ),
                TomorrowAdapterData.Card(

                    TomorrowData(
                        "09:00", R.drawable.sun_cloud, "15°",
                        R.drawable.fluent_drop_16_filled, "60%",
                        R.drawable.freccia, "Percepita", "indice UV",
                        "19°", "1/10", "Umidità", "Vento", "50%",
                        "12 km/h",
                        "Copertura", "Pioggia", "7%", "0cm"
                    )
                ),
                TomorrowAdapterData.Card(

                    TomorrowData(
                        "10:00", R.drawable.suns, "15°",
                        R.drawable.fluent_drop_16_filled, "60%",
                        R.drawable.freccia, "Percepita", "indice UV",
                        "24°", "1/10", "Umidità", "Vento", "20%",
                        "12 km/h",
                        "Copertura", "Pioggia", "7%", "0cm"
                    )
                ),


                )
        )

    }
}