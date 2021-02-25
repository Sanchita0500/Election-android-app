package com.example.election

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.election.databinding.FragmentCandidateBinding


class CandidateFragment : Fragment() {

    lateinit var binding: FragmentCandidateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCandidateBinding.inflate(layoutInflater)
    }

    val candidatesList = mutableListOf(
            Candidate("Changu", "Class_Representative", R.drawable.boy),
            Candidate("Mangu", "Day_Scholars_Representative", R.drawable.boy2),
            Candidate("Rihana", "Ladies_Representative", R.drawable.rihana),
            Candidate("J.Lo", "Ladies_Representative", R.drawable.jlo),
            Candidate("Ramesh", "Class_Representative", R.drawable.ramesh),
            Candidate("Suresh", "Academic_Representative", R.drawable.suresh)
    )

//    val names = mutableListOf<String>("Changu","Mangu","Rihana","J.Lo","Ramesh","Suresh")
//    val posts = mutableListOf<String>("Class_Representative","Day_Scholars_Representative","Ladies_Representative","Ladies_Representative","Class_Representative",
//                                        "Academic_Representative")
//    val images = mutableListOf(R.drawable.boy,R.drawable.boy2,R.drawable.rihana,R.drawable.jlo,R.drawable.ramesh,R.drawable.suresh)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    :View? {
        // Inflate the layout for this fragment
        binding = FragmentCandidateBinding.inflate(layoutInflater)
        val view = inflater.inflate(R.layout.fragment_candidate, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CandidateAdapter(candidatesList,activity!!)
        binding.candidateRecyclerView.adapter= adapter
        binding.candidateRecyclerView.layoutManager=LinearLayoutManager(context)
    }

}