package com.example.sahayak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import android.os.Bundle
import com.example.sahayak.databinding.ActivityButtonactivityBinding
import com.example.sahayak.databinding.ActivityVocationalBinding


class Vocational : ComponentActivity() {
    private lateinit var binding: ActivityVocationalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVocationalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent= Intent(this@Vocational, ButtonActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}