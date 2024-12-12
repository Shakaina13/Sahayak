package com.example.sahayak

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sahayak.databinding.ActivityButtonactivityBinding
import com.example.sahayak.databinding.ProfileActivityBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ButtonActivity : ComponentActivity() {
    private lateinit var binding: ActivityButtonactivityBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityButtonactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnProfile.setOnClickListener {
//            val intent: Intent = intent
            val userName = intent.getStringExtra("userName")
            database = FirebaseDatabase.getInstance().getReference("users")
            database.child(userName.toString()).get().addOnSuccessListener {
                    val username = it.child("username").value
                    val contact = it.child("contact").value
                    val ngo = it.child("ngo").value
                    val jail = it.child("jail").value
                    val proceedings = it.child("proceedings").value
                    val name = it.child("name").value
                    val lawyer = it.child("lawyer").value

                val intent = Intent(this@ButtonActivity, ProfileActivity::class.java)
                intent.putExtra("name", name.toString())
                intent.putExtra("contact", contact.toString())
                intent.putExtra("ngo", ngo.toString())
                intent.putExtra("username", username.toString())
                intent.putExtra("proceedings", proceedings.toString())
                intent.putExtra("jail", jail.toString())
                intent.putExtra("lawyer", lawyer.toString())
                    startActivity(intent)
                    finish()

            }
        }

        binding.btnBack.setOnClickListener {
            val intent = Intent(this@ButtonActivity, NextActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnVocational.setOnClickListener {
            val intent = Intent(this@ButtonActivity, Vocational::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnNgoLaw.setOnClickListener {
            val intent = Intent(this@ButtonActivity, Ngo::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLaw.setOnClickListener {
            val intent = Intent(this@ButtonActivity, Lawyers::class.java)
            startActivity(intent)
            finish()
        }
    }
}