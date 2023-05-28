package com.dkgtech.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.dkgtech.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.root.findViewById(R.id.toolBar))

        val actionBarToggle = ActionBarDrawerToggle(
            this@MainActivity,
            binding.drawerLayout,
            binding.root.findViewById(R.id.toolBar),
            R.string.open_drawer,
            R.string.close_drawer
        )

        binding.drawerLayout.addDrawerListener(actionBarToggle)
        actionBarToggle.syncState()

        binding.navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.drawerHome -> {
                    supportFragmentManager.beginTransaction()
                        .add(com.google.android.material.R.id.container, HomeFragment()).commit()
                }

                R.id.drawerExplore -> {
                    supportFragmentManager.beginTransaction()
                        .add(com.google.android.material.R.id.container, ExploreFragment()).commit()
                }

                else -> {
                    supportFragmentManager.beginTransaction()
                        .add(com.google.android.material.R.id.container, ProfileFragment()).commit()
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onBackPressed() {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }
}