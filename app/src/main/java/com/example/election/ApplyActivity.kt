package com.example.election

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.election.databinding.ActivityApplyBinding

class ApplyActivity : AppCompatActivity() {

    lateinit var binding: ActivityApplyBinding
    val postsArray = mutableListOf<String>("Class_Representative","Ladies_Representative","Sports_Secretary","Sports_Secretary_Female","Treasurer","Technical_Secretary",
            "Cultural_Secretary","Day_Scholars_Representative","Creative_Secretary","Creative_Secretary_Female","Cultural_Secretary_Female","Academic_Representative")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityApplyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username=intent.getStringExtra("name")

        val postAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_list_item_1,postsArray)
        binding.PostsList.adapter = postAdapter
        
        binding.PostsList.setOnItemClickListener { parent, view, position, id ->
            val element = parent.getItemAtPosition(position).toString()
            val intent = Intent(this,ApplyPostActivity::class.java)
            intent.putExtra("name",username)
            intent.putExtra("post",element)
            startActivity(intent)
            finish()
        }
    }
}