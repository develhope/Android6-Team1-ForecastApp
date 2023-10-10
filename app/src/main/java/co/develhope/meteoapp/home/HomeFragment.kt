package co.develhope.meteoapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.FragmentHomeBinding
import co.develhope.meteoapp.home.adapter.HomeAdapter
import co.develhope.meteoapp.home.data.HomeForecast
import org.threeten.bp.OffsetDateTime

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeRecycleView.adapter = HomeAdapter(
            list = Data.getHomeList(),
            onClick = { item ->
                if (item is HomeForecast.HomeDays) {
                    val today = OffsetDateTime.now()
                    if (item.date.dayOfMonth == today.dayOfMonth) {
                        findNavController().navigate(R.id.todayFragment)
                    } else {
                        findNavController().navigate(R.id.tomorrowFragment)
                    }
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
