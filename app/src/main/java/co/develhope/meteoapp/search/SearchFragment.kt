package co.develhope.meteoapp.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val recentSearchList = mutableListOf<SearchData>()
    private val binding get() = _binding!!

    private val cityList = mutableListOf(
        "Palermo, Sicilia",
        "Torino, Piemonte",
        "Milano, Lombardia",
        "Napoli, Campania",
        "Genova, Liguria",
        "Catania, Sicilia",
        "Bologna, Emilia-Romagna",
        "Bari, Puglia",
        "Roma, Lazio",
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        val recyclerView: RecyclerView = binding.cityList
        val adapter = SearchAdapter(cityList, recentSearchList, object : SearchAdapter.OnItemClickListener {
            override fun onItemClick(searchData: SearchData) {
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        val searchView = binding.searchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //Da aggiungere filtri se bisogno
                return false
            }
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}