package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

var E_count =0
var I_count=0
var S_count =0
var N_count=0
var T_count =0
var F_count=0
var J_count =0
var P_count=0

class MainActivity : AppCompatActivity() {
    // lateinit var navController :NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        //navController = nav_host_fragment.findNavController()
    }
}