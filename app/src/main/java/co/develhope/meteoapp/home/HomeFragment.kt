package co.develhope.meteoapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import co.develhope.meteoapp.HomeViewModel
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.local.WeeklyDataLocal
import co.develhope.meteoapp.databinding.FragmentHomeBinding
import co.develhope.meteoapp.home.adapter.HomeAdapter
import co.develhope.meteoapp.home.data.HomeForecast
import org.koin.android.ext.android.inject
import org.threeten.bp.OffsetDateTime

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by inject()

    private val data: Data by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupAdapter() {
        binding.homeRecycleView.adapter = HomeAdapter(
            list = listOf(),
            onClick = { item ->
                when (item) {
                    is HomeForecast.HomeToday -> {
                        data.saveDate(item.date)
                        findNavController().navigate(R.id.home_screen_to_today)
                    }

                    is HomeForecast.HomeDays -> {
                        data.saveDate(item.date)
                        findNavController().navigate(R.id.home_screen_to_tomorrw)
                    }

                    is HomeForecast.HomeSubtitle, is HomeForecast.HomeTitle -> {
                        // do nothings
                    }
                }
            }
        )
    }

    private fun setupObserver() {
        homeViewModel.result.observe(viewLifecycleOwner) {
            (binding.homeRecycleView.adapter as HomeAdapter).setNewList(it.toHomeForecast())
        }
    }

    fun WeeklyDataLocal?.toHomeForecast(): List<HomeForecast> {
        val newList = mutableListOf<HomeForecast>()
        newList.add(HomeForecast.HomeTitle("${data.getSelectedPlace().city}, ${data.getSelectedPlace().country}"))

        this?.forEach { week ->
            if (week.date.dayOfMonth == OffsetDateTime.now().dayOfMonth) {
                newList.add(
                    HomeForecast.HomeToday(
                        date = week.date,
                        minTemperature = week.minTemperature?.toInt() ?: 0,
                        maxTemperature = week.maxTemperature?.toInt() ?: 0,
                        weatherIcon = week.weatherIcon ?: 0,
                        precipitation = week.precipitation?.toInt() ?: 0,
                        windSpeed = week.windSpeed?.toInt() ?: 0
                    )
                )
            }
        }
        newList.add(HomeForecast.HomeSubtitle)

        this?.forEach { week ->
            if (week.date.dayOfMonth != OffsetDateTime.now().dayOfMonth) {
                newList.add(
                    HomeForecast.HomeDays(
                        date = week.date,
                        minTemperature = week.minTemperature?.toInt() ?: 0,
                        maxTemperature = week.maxTemperature?.toInt() ?: 0,
                        weatherIcon = week.weatherIcon ?: 0,
                        precipitation = week.precipitation?.toInt() ?: 0,
                        windSpeed = week.windSpeed?.toInt() ?: 0
                    )
                )
            }
        }
        return newList
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.getDailyInfo(
            lat = data.getSelectedPlace().lat,
            lon = data.getSelectedPlace().long
        )

        setupAdapter()
        setupObserver()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
