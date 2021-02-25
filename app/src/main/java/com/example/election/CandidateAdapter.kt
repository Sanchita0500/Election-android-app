package com.example.election

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CandidateAdapter(val candidateList : List<Candidate>, val context: Context) : RecyclerView.Adapter<CandidateAdapter.CandidateViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidateViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.candidate_layout,parent,false)
        return CandidateViewHolder(view)
    }


    override fun onBindViewHolder(holder: CandidateViewHolder, position: Int) {

        with(holder) {
            candidateName.text = candidateList[position].name
            profileImage.setImageResource(candidateList[position].profileImage)
            candidatePost.text = candidateList[position].post
        }
        holder.bind(candidateList[position])


    }

    override fun getItemCount(): Int {
        return candidateList.size
    }

    class CandidateViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val candidateName = view.findViewById<TextView>(R.id.personName)
        val profileImage = view.findViewById<ImageView>(R.id.personImageView)
        val candidatePost = view.findViewById<TextView>(R.id.personPost)

        fun bind(candidate: Candidate) {
            candidateName.text = candidate.name
            profileImage.setImageResource(candidate.profileImage)
            candidatePost.text = candidate.post
        }

    }
}