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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.FragmentSearchBinding
import co.develhope.meteoapp.domainmodel.Place
import org.koin.android.ext.android.inject


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val viewModel: SearchScreenViewModel by inject()
    private val binding get() = _binding!!


    private var placeList = mutableListOf<Place>()

    private var selectedPlace: String? = null
    private var cityData: String? = null

    private val data: Data by inject()


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

        if (selectedPlace != null && selectedPlace != this.cityData) {
            Log.d("SelectedPlace", "Formatted: $this.cityData")
            sharedPreferences.edit().putString("selected_place", this.cityData).apply()

            val citiesFromNetwork = viewModel.cityList.value ?: emptyList()
            placeList.addAll(citiesFromNetwork)
            placeList = placeList.distinct().toMutableList()
            //END TEST

            setupRecentCity()
            setupUi(placeList, sharedPreferences)
            setupObserver()
            setupSearch()
        }
    }


    private fun setupUi(placeList: List<Place>, sharedPreferences: SharedPreferences) {
        val uniquePlaceList =
            placeList.distinctBy { "${it.city}, ${it.country}".removeSuffix(",").trim() }
        val adapter = SearchAdapter(

            placeList = uniquePlaceList,
            onPlaceClicked = {
                findNavController().navigate(R.id.homeFragment)
                Data.saveSelectedPlace(it)
                onCitySelected(it)
            },
            sharedPreferences = sharedPreferences
        )

            placeList = placeList
        ) {
            findNavController().navigate(R.id.homeFragment)
            data.saveSelectedPlace(it)
        }

        binding.cityList.layoutManager = LinearLayoutManager(requireContext())
        binding.cityList.adapter = adapter

        val maxSavedCities = 5
        if (placeList.size > maxSavedCities) {
            val trimmedPlaceList = placeList.take(maxSavedCities)
            val placeNames =
                trimmedPlaceList.map { "${it.city}, ${it.country}".removeSuffix(",").trim() }
            saveRecentCities(placeNames.toSet())
        }
    }


    private fun onCitySelected(city: Place) {
        val cityName = city.city.trim().removeSuffix(",")
        val regionName = city.country.trim()
        val cityData = "$cityName, $regionName".trim().removeSuffix(",")

        // Log per debug
        Log.d("CityFormat", "Original: ${city.city}, ${city.country}")
        Log.d("CityFormat", "Trimmed: $cityName, $regionName")
        Log.d("CityFormat", "Formatted: $cityData")

        saveRecentCity(cityData)
        // Aggiungi il salvataggio del luogo selezionato solo se è diverso da quello attuale
        if (selectedPlace != cityData) {
            Log.d("SelectedPlace", "Formatted: $cityData")
            sharedPreferences.edit().putString("selected_place", cityData).apply()
        }
    }


    private fun saveRecentCity(recentCity: String) {
        val editor = sharedPreferences.edit()
        editor.putString("recent_city", recentCity)
        editor.apply()
    }


    private fun setupRecentCity() {
        val recentCity = sharedPreferences.getString("recent_city", "")
        if (!recentCity.isNullOrEmpty()) {
            viewModel.getCity(recentCity, "it")
        }
    }


    private fun saveRecentCities(recentCities: Set<String>) {
        val cleanedRecentCities = recentCities.map { it.trim().removeSuffix(",") }.toSet()

        // Log per debug
        Log.d("RecentCities", "Original: $recentCities")
        Log.d("RecentCities", "Cleaned: $cleanedRecentCities")

        val editor = sharedPreferences.edit()
        editor.putStringSet("recent_cities", cleanedRecentCities)
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
                if (!newText.isNullOrEmpty() && newText.length > 3) {
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