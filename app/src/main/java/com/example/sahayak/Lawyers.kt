package com.example.sahayak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import android.os.Bundle
import com.example.sahayak.databinding.ActivityLawyersBinding
import com.example.sahayak.databinding.ActivityVocationalBinding

class Lawyers : ComponentActivity() {
    private lateinit var binding: ActivityLawyersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLawyersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackBack.setOnClickListener { 
            val intent = Intent(this@Lawyers, ButtonActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}