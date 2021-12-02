package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

// mbti테스트를 위한 count
// 다른 fragment에서도 사용해야하기 때문에 전역으로 선언
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

        E_count=0
        I_count=0
        S_count=0
        N_count=0
        T_count=0
        F_count=0
        J_count=0
        P_count=0

        // navigation사용을 위해
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}