package com.example.lovecalculator_5mon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.lovecalculator_5mon.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    @Inject
    lateinit var prefs: Prefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      navController=  findNavController(R.id.nav_host_fragment_activity_main)
        prefs.saveState()

//        Log.e("lololo", "onCreate: ", )

        if (prefs.isShown()) {
            navController.navigate(R.id.boardFragment)
        }
        metod()

    }
    private fun metod() {


    }
}