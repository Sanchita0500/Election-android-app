package com.example.election

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.election.databinding.ActivityApplyPostBinding

class ApplyPostActivity : AppCompatActivity() {

    lateinit var binding: ActivityApplyPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApplyPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("name")
        val post  = intent.getStringExtra("post")

        binding.name.text=username
        binding.post.text=post

        binding.applyButton.setOnClickListener {
            val intent = Intent(this,CandidatesActivity::class.java)
            intent.putExtra("name",username)
            intent.putExtra("post",post)
            startActivity(intent)
            finish()
        }
    }
}