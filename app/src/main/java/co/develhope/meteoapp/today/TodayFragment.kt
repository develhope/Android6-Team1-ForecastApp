package co.develhope.meteoapp.today

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.domain.TodayForecast
import co.develhope.meteoapp.databinding.FragmentTodayBinding
import org.threeten.bp.OffsetDateTime

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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupAdapter() {
        val todayForecast = Data.getTodayForecast()
        val todayTitle = Data.getTodayTitle()
        val todayItems = todayList(todayForecast, todayTitle)
        binding.todayRecycler.adapter = TodayAdapter(todayItems)
    }

    private fun todayList(
        todayCardForecastList : List<TodayForecast>,
        todayTitle : String
    ): List<TodayData> {

        val todayItems = mutableListOf<TodayData>()

        todayItems.add(TodayData.TodayTitleData(todayLocation = todayTitle, todayTitleDate = OffsetDateTime.now()))

        todayCardForecastList.forEach { forecast ->
            todayItems.add(
                TodayData.TodayItemData(
                    forecast = forecast
                )
            )
        }
        return todayItems.toList()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}