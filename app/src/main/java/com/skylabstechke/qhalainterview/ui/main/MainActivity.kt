package com.skylabstechke.qhalainterview.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.skylabstechke.qhalainterview.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBarWithNavController(findNavController(R.id.Nav))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHost = findNavController(R.id.my_nav_host).navigateUp()
        return navHost || super.onSupportNavigateUp()
    }
}