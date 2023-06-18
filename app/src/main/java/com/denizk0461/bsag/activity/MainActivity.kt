package com.denizk0461.bsag.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.denizk0461.bsag.R
import com.denizk0461.bsag.databinding.ActivityMainBinding

/**
 * Main activity that handles all common fragments. This is opened on app launch.
 */
class MainActivity : AppCompatActivity() {

    // View binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up navigation graph
        binding.fragmentContainer.getFragment<NavHostFragment>().setupNavigationGraph()
    }

    /**
     * Inflates and sets the navigation graph to use fragment with the Navigation Component.
     */
    private fun NavHostFragment.setupNavigationGraph() {
        // Inflate new nav graph
        val navGraph = this.navController.navInflater.inflate(R.navigation.navigation_graph)

        // Set the newly defined nav graph
        this.navController.graph = navGraph
    }
}