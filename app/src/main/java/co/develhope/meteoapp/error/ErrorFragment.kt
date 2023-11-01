package co.develhope.meteoapp.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import co.develhope.meteoapp.MainActivity
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.FragmentErrorScreenBinding
import co.develhope.meteoapp.networkAvailability

class ErrorFragment : Fragment() {

    private var _binding: FragmentErrorScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentErrorScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            }
        )

        binding.errorbuttonretry.setOnClickListener {
            if (networkAvailability(requireContext())) {
                findNavController().navigate(R.id.homeFragment)

                (activity as? MainActivity)?.setBottomNavVisibility(View.VISIBLE)
            }
        }
    }
}