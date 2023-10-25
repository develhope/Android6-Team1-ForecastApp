package co.develhope.meteoapp.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.FragmentSearchBinding
import co.develhope.meteoapp.domainmodel.Place


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val viewModel: SearchScreenViewModel = ViewModelProvider(this)[SearchScreenViewModel::class.java]
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi(emptyList())
        setupObserver()
        setupSearch()
    }

    private fun setupUi(placeList: List<Place>) {
        val adapter = SearchAdapter(
            placeList = placeList
        ) {
            findNavController().navigate(R.id.homeFragment)
            Data.saveSelectedPlace(it)
        }
        binding.cityList.layoutManager = LinearLayoutManager(requireContext())
        binding.cityList.adapter = adapter

    }

    private fun setupObserver() {
        viewModel.cityList.observe(viewLifecycleOwner) {
            setupUi(it)
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
                newText?.let {
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