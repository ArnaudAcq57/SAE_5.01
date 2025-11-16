package com.example.sae_5_01_frontend

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.sae_5_01_frontend.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Récupérer correctement le NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)
                    as NavHostFragment

        // Récupérer le NavController depuis le NavHostFragment
        val navController = navHostFragment.navController

        // Lier la BottomNavigationView au NavController
        binding.navView.setupWithNavController(navController)
    }
}
