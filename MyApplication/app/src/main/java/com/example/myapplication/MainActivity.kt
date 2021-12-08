package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

// fragment가 너무 많아서 viewpager를 이용해보려 했으니
// 장장 6시간 투자 후 실패하고 원래 방식으로 복귀...
class MainActivity : AppCompatActivity() {
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init() // 처음화면으로 오면 count들 초기화

        // navigation사용을 위해 -> // navController가 쓰이지 않는 이유 : xml에서 activity와 fragment를 연결해줬기 때문
        //val navHostFragment =
        //    supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        //val navController = navHostFragment.navController
    }
    
    // 뒤로가기 눌렀을 시 처음 화면으로
    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    // 다른 fragment에서도 사용해야하기 때문에 companion
    companion object{
        var E_count = 0
        var I_count = 0
        var S_count = 0
        var N_count = 0
        var T_count = 0
        var F_count = 0
        var J_count = 0
        var P_count = 0

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
    }
}