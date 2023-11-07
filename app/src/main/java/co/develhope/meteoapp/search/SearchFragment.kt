package co.develhope.meteoapp.search

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.FragmentSearchBinding
import co.develhope.meteoapp.domainmodel.Place


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val viewModel: SearchScreenViewModel by viewModels()
    private val binding get() = _binding!!

    private val placeList = mutableListOf<Place>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val sharedPreferences by lazy {
        requireContext().getSharedPreferences("meteo_preferences", Context.MODE_PRIVATE)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TEST
        val selectedPlace = sharedPreferences.getString("selected_place", "")
        Log.d("SelectedPlace", "Value: $selectedPlace")

        if (!selectedPlace.isNullOrEmpty() && !placeList.any { it.city == selectedPlace }) {
            placeList.add(Place(selectedPlace, "", 2.4, 4.3))

            val citiesFromNetwork = viewModel.cityList.value ?: emptyList()
            placeList.addAll(citiesFromNetwork)
            placeList.distinct()
            //END TEST


            setupUi(placeList, sharedPreferences)
            setupObserver()
            setupSearch()
        }
    }


    private fun setupUi(placeList: List<Place>, sharedPreferences: SharedPreferences) {
        val uniquePlaceList = placeList.distinctBy { it.city }
        val adapter = SearchAdapter(
            placeList = uniquePlaceList,
            onPlaceClicked = {
                findNavController().navigate(R.id.homeFragment)
                Data.saveSelectedPlace(it)
                onCitySelected(it)
            },
            sharedPreferences = sharedPreferences
        )
        binding.cityList.layoutManager = LinearLayoutManager(requireContext())
        binding.cityList.adapter = adapter

        val maxSavedCities = 5
        if (placeList.size > maxSavedCities) {
            val trimmedPlaceList = placeList.take(maxSavedCities)
            val placeNames = trimmedPlaceList.map { "${it.city}, ${it.country}" }
            saveRecentCities(placeNames.toSet())
        }
    }
    private fun onCitySelected(city: Place) {
        val recentCitiesSet = sharedPreferences.getStringSet("recent_cities", setOf())?.toMutableSet()
        val cityData = "${city.city}, ${city.country}"
        recentCitiesSet?.add(cityData)
        saveRecentCities(recentCitiesSet ?: setOf())
    }

    private fun saveRecentCities(recentCities: Set<String>) {
        val editor = sharedPreferences.edit()
        editor.putStringSet("recent_cities", recentCities)
        editor.apply()
    }

    private fun setupObserver() {
        viewModel.cityList.observe(viewLifecycleOwner) {
            setupUi(it, sharedPreferences)
        }
    }

    private fun setupSearch() {
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.getCity(query, "it")
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrEmpty() && (newText.length > 3)) {
                    viewModel.getCity(newText, "it")
                }
                return true
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}