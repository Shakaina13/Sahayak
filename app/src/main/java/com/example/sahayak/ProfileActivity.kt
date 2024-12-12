package com.example.sahayak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import android.os.Bundle
import com.example.sahayak.databinding.ProfileActivityBinding

class ProfileActivity : ComponentActivity() {

    private lateinit var binding : ProfileActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProfileActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showAllUserData()
        binding.btnDone.setOnClickListener{
            val intent = Intent(this@ProfileActivity, ButtonActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
   private fun showAllUserData(){
       val intent: Intent = intent
       val name = intent.getStringExtra("name")
       val username = intent.getStringExtra("username")
       val contact = intent.getStringExtra("contact")
       val ngo = intent.getStringExtra("ngo")
       val jail = intent.getStringExtra("jail")
       val proceedings = intent.getStringExtra("proceedings")
       val lawyer = intent.getStringExtra("lawyer")

       binding.txtNameText.text = name.toString()
       binding.txtUserName.text= username.toString()
       binding.txtLawyerName.text= lawyer.toString()
       binding.edtPhone.setText(contact)
       binding.edtJail.setText(jail)
       binding.edtNgo.setText(ngo)
       binding.edtProceedings.setText(proceedings)




   }

}