package com.example.sahayak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import android.os.Bundle
import com.example.sahayak.databinding.ActivityNgoBinding
import com.example.sahayak.databinding.ActivityVocationalBinding

class Ngo : ComponentActivity() {
    private lateinit var binding: ActivityNgoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNgoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoBack.setOnClickListener {
            val intent = Intent(this@Ngo, ButtonActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}