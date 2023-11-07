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

        setupUi(emptyList(), sharedPreferences)
        setupObserver()
        setupSearch()


        val allData = sharedPreferences.all
        for ((key, value) in allData) {
            Log.d("SharedPreferences", "Key: $key, Value: $value")
        }

    }

    private fun setupUi(placeList: List<Place>, sharedPreferences: SharedPreferences) {
        val adapter = SearchAdapter(
            placeList = placeList,
            onPlaceClicked = {
                findNavController().navigate(R.id.homeFragment)
                Data.saveSelectedPlace(it)
            },
            sharedPreferences = sharedPreferences
        )
        binding.cityList.layoutManager = LinearLayoutManager(requireContext())
        binding.cityList.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.cityList.observe(viewLifecycleOwner) {
            setupUi(it, sharedPreferences)
        }
    }

    private fun setupSearch() {
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                /*query?.let {
                    viewModel.getCity(query, "it")
                }*/
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrEmpty() && newText.length > 3){
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