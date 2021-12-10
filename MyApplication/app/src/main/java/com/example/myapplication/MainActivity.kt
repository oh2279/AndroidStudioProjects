package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

// 12/08 fragment가 너무 많아서 viewpager를 이용해보려 했으나 (기존 프래그먼트 15개)
// 장장 6시간 투자 후 실패하고 원래 방식으로 복귀...

// 12/10 5시간 구글링 및 공부 후 뷰페이저2 성공
class MainActivity : AppCompatActivity() {
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init() // 처음화면으로 오면 count들 초기화

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        //val navController = navHostFragment.navController
    }
    
    // 뒤로가기 눌렀을 시 처음 화면으로
    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun init(){
        E_count = 0
        I_count = 0
        S_count = 0
        N_count = 0
        T_count = 0
        F_count = 0
        J_count = 0
        P_count = 0
    }
    companion object{
        var E_count = 0
        var I_count = 0
        var S_count = 0
        var N_count = 0
        var T_count = 0
        var F_count = 0
        var J_count = 0
        var P_count = 0
    }
}