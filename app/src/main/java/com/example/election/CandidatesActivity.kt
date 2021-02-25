package com.example.election

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.election.databinding.ActivityCandidatesBinding

class CandidatesActivity : AppCompatActivity() {

    lateinit var binding: ActivityCandidatesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCandidatesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarCandidates)

        val viewPagerAdapter = viewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(CandidateFragment(),"Candidates")
        viewPagerAdapter.addFragment(VoteFragment(),"Vote")

        binding.viewPager.adapter=viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    internal class viewPagerAdapter(fragmentManager: FragmentManager)
        : FragmentStatePagerAdapter(fragmentManager){

        private val fragments : ArrayList<Fragment>
        private val titles : ArrayList<String>

        init {
            fragments = ArrayList<Fragment>()
            titles = ArrayList<String>()
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        fun addFragment(fragment:Fragment,title: String)
        {
            fragments.add(fragment)
            titles.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }

    }
}