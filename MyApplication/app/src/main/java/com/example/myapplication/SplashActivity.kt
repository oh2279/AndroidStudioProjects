package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


// 시작 로딩화면
class splash_activity : AppCompatActivity() {

    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT:Long = 2000 // 2 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashactivity)

        // 잠깐 기다렸다가 시작
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            // close splash activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}