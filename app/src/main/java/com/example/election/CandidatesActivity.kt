package com.example.election

import android.content.Context
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.election.databinding.ActivityCandidatesBinding

class CandidatesActivity : AppCompatActivity() {

    lateinit var binding: ActivityCandidatesBinding

    val list = mutableListOf(
            Candidate("Changu","Class_Representative",R.drawable.boy),
            Candidate("Mangu","Class_Representative",R.drawable.boy2),
            Candidate("Rihana","Ladies_Representative",R.drawable.rihana),
            Candidate("J.Lo","Ladies_Representative",R.drawable.jlo),
            Candidate("Ramesh","Cultural_Representative",R.drawable.ramesh),
            Candidate("Suresh","Academic_Representative",R.drawable.suresh)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCandidatesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("name")
        val post = intent.getStringExtra("post")

        if(username!=null && post!=null) {
            list.add(Candidate(username!!, post!!, R.drawable.vote_button))
        }

        binding.personRecyclerView.adapter = CandidateAdapter(list,this)
        binding.personRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun goBack(view : View){
        finish()
    }

}