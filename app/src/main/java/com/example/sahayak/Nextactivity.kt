package com.example.sahayak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sahayak.databinding.ActivityNextactivityBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class NextActivity : ComponentActivity() {
    private lateinit var binding: ActivityNextactivityBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val password :String = binding.edtPass.text.toString()
            val userName :String = binding.edtUser.text.toString()

            if  (userName.isNotEmpty() || password.isNotEmpty()){

                readData(userName)
            }else{

                Toast.makeText(this,"PLease enter the password",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun readData(userName:String) {
        database = FirebaseDatabase.getInstance().getReference("users")
        database.child(userName).get().addOnSuccessListener {
            if (it.exists()){
                val intent = Intent(this@NextActivity, ButtonActivity::class.java)
                intent.putExtra("userName", userName)
                binding.edtPass.text.clear()
                binding.edtUser.text.clear()


//                val intent = Intent(this@NextActivity, ProfileActivity::class.java)
                startActivity(intent)

                finish()
            }else{

                Toast.makeText(this,"User Doesn't Exist",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{

            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }
}












