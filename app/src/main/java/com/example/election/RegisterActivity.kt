package com.example.election

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.election.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.alreadyHaveAccountLink.setOnClickListener {
            intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.registerButton.setOnClickListener {
            AddUser()
        }
    }

    fun AddUser(){

        val username = binding.registerEmail.text.toString()
        val password = binding.registerPassword.text.toString()
        val cnfmPassword = binding.registerCnfmPassword.text.toString()

        if (password!=cnfmPassword){
            Toast.makeText(this,"Password Incorrect",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"User added",Toast.LENGTH_SHORT).show()
            intent = Intent(this,LoginActivity::class.java)
            intent.putExtra("username",username)
            intent.putExtra("password",password)
            startActivity(intent)
            finish()
        }
    }
}