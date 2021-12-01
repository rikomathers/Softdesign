package com.example.tz.framework

import android.os.Bundle
import android.util.Log
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.example.tz.R
import com.example.tz.databinding.ActivityMainBinding
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity : AppCompatActivity(), MainNavController {
    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null
        get() {
            if (field == null) {
                Log.d("TAG", "NavController is NULL")
            }
            return field
        }
    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navMain()
    }
    @InternalCoroutinesApi
    private fun createNavHost(@NavigationRes graphId: Int) {
        val newNavHostFragment =
            MainNavHostFragment.create(
                graphId
            )
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_nav_host_container,
                newNavHostFragment,
                getString(R.string.NavHostFragmentTag)
            )
            .setPrimaryNavigationFragment(newNavHostFragment)
            .commit()
    }

    override fun navController() = navController

    override fun setNavController(navController: NavController) {
        this.navController = navController
    }
    @InternalCoroutinesApi
    override fun navMain() {
        createNavHost(
            R.navigation.mobile_navigation
        )
    }
}