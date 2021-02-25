package com.example.election

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.election.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding:ActivityLoginBinding
    var Users: MutableList<Pair<String?, String?>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            Validate()
        }

        binding.needNewAccountLink.setOnClickListener{
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        val User = intent.getStringExtra("username")
        val Pass = intent.getStringExtra("password")
        Users.add(Pair(User,Pass))
    }

    fun Validate(){

        val username=binding.loginEmail.text.toString()
        val password=binding.loginPassword.text.toString()
        var flag=0

        for (user in Users){
            if(user.first==username && user.second==password){
                flag=1
                intent = Intent(this, MainActivity::class.java)
                intent.putExtra("name",username)
                startActivity(intent)
                finish()
            }
        }
        if(flag==0){
            Toast.makeText(this,"Incorrect Username or password",Toast.LENGTH_SHORT).show()
        }
    }
}