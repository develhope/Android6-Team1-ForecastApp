package co.develhope.meteoapp.tomorrow

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.FragmentTomorrowBinding
import co.develhope.meteoapp.tomorrow.adapter.TomorrowAdapter

class TomorrowFragment : Fragment() {

    private var _binding: FragmentTomorrowBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTomorrowBinding.inflate(inflater, container, false)

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupAdapter() {
        val tomorrowItem = Data.getTomorrowList()
        binding.dayList.adapter = TomorrowAdapter(tomorrowItem)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}