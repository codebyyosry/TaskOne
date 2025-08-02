package com.yosry.dev.taskone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  // ✅ MUST be called first!
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            // Use system splash
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            // Show manual splash for older devices
            setTheme(R.style.Theme_MyApp_Splash)
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 2000)
        }
    }
}