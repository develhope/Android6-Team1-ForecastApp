package co.develhope.meteoapp

import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import co.develhope.meteoapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.bottomNavigationView.setupWithNavController(findNavController(R.id.nav_host_fragment_content_main))
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        val bottomNav: BottomNavigationView = binding.bottomNavigationView
        bottomNav.setupWithNavController(navController)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.searchFragment -> {
                    if (!navController.popBackStack(R.id.searchFragment, false)) {
                        it.onNavDestinationSelected(navController)
                    }
                    true
                }

                R.id.homeFragment -> {
                    if (!navController.popBackStack(R.id.homeFragment, false)) {
                        it.onNavDestinationSelected(navController)
                    }

                    true
                }

                else -> {
                    it.onNavDestinationSelected(navController)
                }
            }
        }
    }

    // Funzione per mostrare l'Error Dialog
    fun hideBottomNavigationView() {
        binding.bottomNavigationView.visibility = INVISIBLE
    }

    fun showBottomNavigationView() {
        binding.bottomNavigationView.visibility = VISIBLE
    }
}