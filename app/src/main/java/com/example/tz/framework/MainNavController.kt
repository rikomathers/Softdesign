package com.example.tz.framework

import androidx.navigation.NavController

interface MainNavController {

    fun navController(): NavController?

    fun setNavController(navController: NavController)
    fun navMain()
}