package com.unsoed.responsi1mobileh1d023034

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.responsi1mobileh1d023034.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        binding.layoutHistory.let {
            it.imgIcon.setImageResource(R.drawable.ic_ball)
            it.tvLayout.setText(R.string.club_history)
        }
        binding.layoutCoach.let {
            it.imgIcon.setImageResource(R.drawable.ic_head)
            it.tvLayout.setText(R.string.coach_info)
        }
        binding.layoutPlayer.let {
            it.imgIcon.setImageResource(R.drawable.ic_team)
            it.tvLayout.setText(R.string.player_info)
        }
    }

    private fun initListener() {
        binding.layoutHistory.root.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
        binding.layoutCoach.root.setOnClickListener {
            startActivity(Intent(this, CoachActivity::class.java))
        }
        binding.layoutPlayer.root.setOnClickListener {
            startActivity(Intent(this, DaftarPlayerActivity::class.java))
        }
    }
}
