package co.develhope.meteoapp.today

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.DailyViewModel
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.domain.TodayForecast
import co.develhope.meteoapp.data.local.TodayDataLocal
import co.develhope.meteoapp.databinding.FragmentTodayBinding
import co.develhope.meteoapp.today.adapter.TodayAdapter
import co.develhope.meteoapp.today.model.TodayData
import org.koin.android.ext.android.inject
import org.threeten.bp.OffsetDateTime

class TodayFragment : Fragment() {
    private var _binding: FragmentTodayBinding? = null
    private val binding get() = _binding!!

    private val dailyViewModel: DailyViewModel by inject()

    private val data: Data by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dailyViewModel.getDailyInfo(
            lat = data.getSelectedPlace()?.lat ?: 38.132,
            lon = data.getSelectedPlace()?.long ?: 13.3356
        )

        setupAdapter()
        setupObserver()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupAdapter() {
        binding.todayRecycler.adapter = TodayAdapter(listOf())
    }

    fun setupObserver() {
        dailyViewModel.result.observe(viewLifecycleOwner) {
            (binding.todayRecycler.adapter as TodayAdapter).setNewTodayList(it.toTodayForecastItem())
        }
    }

    fun TodayDataLocal?.toTodayForecastItem(): List<TodayData> {

        val newList = mutableListOf<TodayData>()

        newList.add(
            TodayData.TodayTitleData(
                "${data.getSelectedPlace()?.city.orEmpty()}, ${data.getSelectedPlace()?.country.orEmpty()} ",
                OffsetDateTime.now()
            )
        )

        this?.forEach { hourly ->
            newList.add(
                TodayData.TodayItemData(
                    TodayForecast(
                        todayDate = hourly.time,
                        todayDegrees = hourly.temperature2m?.toInt() ?: 0,
                        todayRainfall = hourly.rainChance ?: 0,
                        todayPerceivedDegrees = hourly.apparentTemperature?.toInt() ?: 0,
                        todayUvIndexFactor = hourly.uvIndex?.toInt() ?: 0,
                        todayHumidityDegrees = hourly.humidity ?: 0,
                        todayWindDirection = hourly.windDirection.toString(),
                        todayWindSpeed = hourly.windSpeed?.toInt() ?: 0,
                        todayCoverageFactor = hourly.cloudCover ?: 0,
                        todayRainFactor = hourly.rain?.toInt() ?: 0,
                        forecastIndex = hourly.weathercode ?: 0,
                        todayArrow = hourly.weathercode ?: 0,
                        todayRainfallPicture = hourly.weathercode ?: 0
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