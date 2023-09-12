package co.develhope.meteoapp.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.FragmentHomeBinding
import co.develhope.meteoapp.databinding.FragmentSearchBinding
class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val cityList = mutableListOf(
        City("Palermo"),
        City("Torino"),
        City("Milano"),
        City("Napoli"),
        City("Genova"),
        City("Catania"),
        City("Salerno"),
        City("Bari")
    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        val recyclerView: RecyclerView = binding.cityList
        val adapter = CityAdapter(cityList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}