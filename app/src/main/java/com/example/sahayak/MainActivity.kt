package com.example.sahayak

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.view.WindowManager
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.example.sahayak.databinding.ActivityMainBinding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sahayak.ui.theme.SahayakTheme

public const val SPLASH_TIME = 4000L

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )

        Handler(Looper.myLooper()!!).postDelayed({
                val intent = Intent(this@MainActivity, NextActivity::class.java)
                startActivity(intent)
                finish()
            }, SPLASH_TIME)

        val fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.animation)
            binding.logo.animation = fadeInAnim

        }

}