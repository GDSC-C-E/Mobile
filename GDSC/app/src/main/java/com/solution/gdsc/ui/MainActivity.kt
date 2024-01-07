package com.solution.gdsc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.solution.gdsc.R
import com.solution.gdsc.base.BaseActivity
import com.solution.gdsc.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun setLayout() {
        val bottomNavigationView = binding.bottomNavigationMain
        val navController =
            supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            bottomNavigationView.setupWithNavController(it)
        }

    }

    override fun onResume() {
        super.onResume()
        changeNavigationColor()
    }

    private fun changeNavigationColor() {
        val navController = supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.navigation_camera) {
                binding.bottomNavigationMain.setBackgroundResource(R.color.black_300)
            } else {
                binding.bottomNavigationMain.setBackgroundResource(R.color.white)
            }
        }
    }
}