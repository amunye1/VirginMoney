package com.tc.virginmoney

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tc.virginmoney.databinding.ActivityMainBinding

// This is the main activity, controlling the app's navigation.
class MainActivity : AppCompatActivity() {

    // This represents the app's layout.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This inflates the app's layout.
        binding = ActivityMainBinding.inflate(layoutInflater)
        // This sets the content view to the app's layout.
        setContentView(binding.root)
        // This helps with navigation.
        val navView: BottomNavigationView = binding.navView

        // This helps with navigation.
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        // This defines the top-level destinations in the app, like which screens are important.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_people, R.id.navigation_rooms
            )
        )
        // This sets up the action bar to work with the navigation controller.
        setupActionBarWithNavController(navController, appBarConfiguration)
        // This connects the bottom navigation bar with the navigation controller.
        navView.setupWithNavController(navController)
    }
}