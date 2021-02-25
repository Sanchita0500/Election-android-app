package com.example.election

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.election.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val username = intent.getStringExtra("name")

        val sound : MediaPlayer = MediaPlayer.create(this, R.raw.sad_game)
        val drawerToggle = ActionBarDrawerToggle(this, binding.drawer, binding.toolbar, R.string.open, R.string.close)
        binding.drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_view_headline_24)

        binding.voteButton.setOnClickListener {

            sound.start()

            binding.konfetti.build()
                .addColors(Color.RED, Color.BLUE, Color.BLACK)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square, Shape.Circle)
                .addSizes(Size(12, 5f))
                .setPosition(-50f, binding.konfetti.width + 50f, -50f, -50f)
                .streamFor(300, 5000L)

        }

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            val intent: Intent
            when (menuItem.itemId) {
                R.id.apply -> {
                    intent = Intent(this, ApplyActivity::class.java)
                    intent.putExtra("name",username)
                    startActivity(intent)
                }
                R.id.candidates -> {
                    intent = Intent(this, CandidatesActivity::class.java)
                    //intent.putExtra("name",username)
                    startActivity(intent)
                }
            }
            binding.drawer.closeDrawer(GravityCompat.START)
            false
        }

        val navheader : View =binding.navView.getHeaderView(0)
        val name : TextView = navheader.findViewById(R.id.header)
        name.setText("Hello ${username}")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        return when(item.itemId){
            android.R.id.home -> {
                binding.drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}