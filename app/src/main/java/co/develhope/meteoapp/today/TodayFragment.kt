package co.develhope.meteoapp.today

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.FragmentHomeBinding
import co.develhope.meteoapp.databinding.FragmentTodayBinding
class TodayFragment : Fragment() {
    private var _binding: FragmentTodayBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.todayscreen.adapter = TodayAdapter(
            listOf(
                TodayData(
                    "11:00", R.drawable.sun, "31°",
                    R.drawable.raindrop, "0%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "12:00", R.drawable.sun, "32°",
                    R.drawable.raindrop, "0%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "13:00", R.drawable.sun, "35°",
                    R.drawable.raindrop, "0%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "14:00", R.drawable.fluent_emoji_sun_behind_rain_cloud, "29°",
                    R.drawable.raindrop, "60%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "15:00", R.drawable.fluent_emoji_sun_behind_rain_cloud, "26°",
                    R.drawable.raindrop, "70%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "16:00", R.drawable.sun, "28°",
                    R.drawable.raindrop, "0%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "17:00", R.drawable.sun_cloud, "31°",
                    R.drawable.raindrop, "0%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "18:00", R.drawable.sun, "30°",
                    R.drawable.raindrop, "0%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "19:00", R.drawable.sun, "27°",
                    R.drawable.raindrop, "0%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "20:00", R.drawable.sun, "32°",
                    R.drawable.raindrop, "0%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "21:00", R.drawable.sun_cloud, "33°",
                    R.drawable.raindrop, "0%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "22:00", R.drawable.fluent_emoji_sun_behind_rain_cloud, "31°",
                    R.drawable.raindrop, "30%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "23:00", R.drawable.sun, "28°",
                    R.drawable.raindrop, "0%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),

                TodayData(
                    "00:00", R.drawable.sun, "30°",
                    R.drawable.raindrop, "0%",
                    R.drawable.arrow,
                    "Percepita",
                    "45°",
                    "Indice UV",
                    "5/10",
                    "Umidità",
                    "60%",
                    "Vento",
                    "SSE 7km/h",
                    "Copertura",
                    "24%",
                    "Pioggia",
                    "0cm"
                ),
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}