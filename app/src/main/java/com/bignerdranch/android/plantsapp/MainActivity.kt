package com.bignerdranch.android.plantsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.bignerdranch.android.plantsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Hide labels for all items
        bottomNavigationView.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_UNLABELED

        // Set up fragment navigation when a bottom navigation item is selected
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    // Replace with HomeFragment (or your desired fragment)
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.navigation_dashboard -> {
                    // Replace with PlantListFragment when "My Plant Shelf" is selected
                    replaceFragment(PlantListFragment())
                    true
                }
                R.id.navigation_notifications -> {
                    // Replace with AccountFragment (or your desired fragment)
                    //replaceFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }

        // Optionally, set the default fragment to display when the app starts
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())  // Default fragment
        }

        // Handle window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
    }

    // Helper function to replace fragments
    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)  // Optional: adds to back stack
        transaction.commit()
    }
}
