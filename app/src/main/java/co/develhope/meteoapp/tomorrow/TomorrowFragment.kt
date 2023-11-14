package co.develhope.meteoapp.tomorrow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.TomorrowViewModel
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.domain.TomorrowForecast
import co.develhope.meteoapp.data.local.TomorrowDataLocal
import co.develhope.meteoapp.databinding.FragmentTomorrowBinding
import co.develhope.meteoapp.tomorrow.adapter.TomorrowAdapter
import co.develhope.meteoapp.tomorrow.model.TomorrowData
import org.koin.android.ext.android.inject
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

class TomorrowFragment : Fragment() {

    private val tomorrowViewModel: TomorrowViewModel by inject()
    private var _binding: FragmentTomorrowBinding? = null
    private val binding get() = _binding!!

    private val data: Data by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTomorrowBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedDate = data.getDate()!!.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"))

        tomorrowViewModel.getDailyInfo(
            lat = data.getSelectedPlace()?.lat ?: 38.132,
            lon = data.getSelectedPlace()?.long ?: 13.3356,
            start = selectedDate,
            end = selectedDate
        )

        setupAdapter()
        setupObserver()
    }


    private fun setupAdapter() {
        binding.dayList.adapter = TomorrowAdapter(listOf())
    }

    fun setupObserver() {
        tomorrowViewModel.result.observe(viewLifecycleOwner) {
            (binding.dayList.adapter as TomorrowAdapter).setNewTomorrowList(
                it.toTomorrowForecastItem(data)
            )
        }
    }

    fun TomorrowDataLocal?.toTomorrowForecastItem(data: Data): List<TomorrowData> {
        val newList = mutableListOf<TomorrowData>()

        newList.add(
            TomorrowData.TomorrowTitle(
                "${data.getSelectedPlace()?.city.orEmpty()}, ${data.getSelectedPlace()?.country.orEmpty()}",
                data.getDate() ?: OffsetDateTime.now().plusDays(1)
            )
        )

        this?.forEach { hourly ->
            newList.add(
                TomorrowData.TomorrowCard(
                    TomorrowForecast(
                        tomorrowDate = hourly.time,
                        tomorrowDegrees = hourly.temperature2m?.toInt() ?: 0,
                        tomorrowRainfall = hourly.rainChance ?: 0,
                        tomorrowPerceivedDegrees = hourly.apparentTemperature?.toInt() ?: 0,
                        tomorrowUvIndexFactor = hourly.uvIndex?.toInt() ?: 0,
                        tomorrowHumidityDegrees = hourly.humidity ?: 0,
                        tomorrowWindDirection = hourly.windDirection.toString(),
                        tomorrowWindSpeed = hourly.windSpeed?.toInt() ?: 0,
                        tomorrowCoverageFactor = hourly.cloudCover ?: 0,
                        tomorrowRainFactor = hourly.rain?.toInt() ?: 0,
                        forecastIndex = hourly.weathercode ?: 0,
                        tomorrowArrow = hourly.weathercode ?: 0,
                        tomorrowRainfallPicture = hourly.weathercode ?: 0
                    )
                )
            )
        }
        return newList
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}