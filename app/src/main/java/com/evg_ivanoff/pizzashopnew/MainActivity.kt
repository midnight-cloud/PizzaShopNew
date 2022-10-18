package com.evg_ivanoff.pizzashopnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.evg_ivanoff.pizzashopnew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.main_fragment_container)
//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.navigation_menu,
//            R.id.navigation_profile,
//            R.id.navigation_basket
//        ))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navMenu.setupWithNavController(navController)
    }
}