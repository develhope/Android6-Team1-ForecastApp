package co.develhope.meteoapp.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.FragmentSearchBinding
import co.develhope.meteoapp.domainmodel.result.EventActionResult


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private lateinit var viewModel: SearchScreenViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.cityList
        val recentSearchList: List<EventActionResult> = emptyList()
        val adapter = SearchAdapter(
            object : SearchAdapter.OnItemClickListener {
                override fun onItemClick(cityName: String) {
                    findNavController().navigate(R.id.homeFragment)
                }
            },
            recentSearchList
        )

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this)[SearchScreenViewModel::class.java]

        viewModel.cityList.observe(viewLifecycleOwner) {
        }

        val searchView = binding.searchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.getCity(query, "it")
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}