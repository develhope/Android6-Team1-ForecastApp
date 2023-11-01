package co.develhope.meteoapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.develhope.meteoapp.HomeViewModel
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.local.WeeklyDataLocal
import co.develhope.meteoapp.databinding.FragmentHomeBinding
import co.develhope.meteoapp.home.adapter.HomeAdapter
import co.develhope.meteoapp.home.data.HomeForecast
import org.threeten.bp.OffsetDateTime

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupAdapter() {

        binding.homeRecycleView.adapter = HomeAdapter(listOf()) {}

    }
    private fun setupObserver() {
        homeViewModel.result.observe(viewLifecycleOwner) {
            (binding.homeRecycleView.adapter as HomeAdapter).setNewList(it.toHomeForecast())
        }
    }


    fun WeeklyDataLocal?.toHomeForecast(): List<HomeForecast> {
        val newList = mutableListOf<HomeForecast>()
        newList.add(HomeForecast.HomeTitle("Palermo, Sicilia"))

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
        homeViewModel.getDailyInfo(38.132, 13.3356)



        setupAdapter()
        setupObserver()

//        binding.homeRecycleView.adapter = HomeAdapter(
//            list = Data.getHomeList(),
//            onClick = { item ->
//                if (item is HomeForecast.HomeDays) {
//                    val today = OffsetDateTime.now()
//                    if (item.date.dayOfMonth == today.dayOfMonth) {
//                        findNavController().navigate(R.id.todayFragment)
//                    } else {
//                        findNavController().navigate(R.id.tomorrowFragment)
//                    }
//                }
//            }
//        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
