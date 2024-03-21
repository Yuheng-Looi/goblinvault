package com.seedling.demo.hostdeveloperdemo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val IVSplashImage = findViewById<ImageView>(R.id.IVSplashImage)
        IVSplashImage.setOnClickListener {
            val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
            startActivity(intent)

            // Finish the SplashScreenActivity to prevent going back to it from LoginActivity
            finish()
        }
    }
}