package co.develhope.meteoapp.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.HomeFragment
import co.develhope.meteoapp.databinding.FragmentSearchBinding
class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val cityList = mutableListOf(
        SearchData("Palermo, Sicilia"),
        SearchData("Torino, Piemonte"),
        SearchData("Milano, Lombardia"),
        SearchData("Napoli, Campania"),
        SearchData("Genova, Liguria"),
        SearchData("Catania, Sicilia"),
        SearchData("Bologna, Emilia-Romagna"),
        SearchData("Bari, Puglia"),
        SearchData("Roma, Lazio"),
        SearchData("Catanzaro, Calabria")
    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        val recyclerView: RecyclerView = binding.cityList
        val adapter = SearchAdapter(cityList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : SearchAdapter.OnItemClickListener {
            override fun onItemClick(searchData: SearchData) {
                val action = SearchFragmentDirections.actionSearchFragmentToHomeFragment()
                findNavController().navigate(action)
            }
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}