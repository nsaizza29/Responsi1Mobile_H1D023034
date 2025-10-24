package com.unsoed.responsi1mobileh1d023034

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.unsoed.responsi1mobileh1d023034.data.network.RetrofitInstance
import com.unsoed.responsi1mobileh1d023034.databinding.ActivityCoachBinding
import com.unsoed.responsi1mobileh1d023034.utils.Constants
import kotlinx.coroutines.launch

class CoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoachBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchCoachData()
    }

    private fun fetchCoachData() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getTeamById(Constants.API_TOKEN, Constants.TEAM_ID)
                if (response.isSuccessful) {
                    val coach = response.body()?.coach
                    if (coach != null) {
                        binding.tvCoachName.text = coach.name ?: "-"
                        binding.tvCoachBirth.text = coach.dateOfBirth ?: "-"
                        binding.tvCoachNationality.text = coach.nationality ?: "-"
                    } else {
                        Toast.makeText(this@CoachActivity, "Coach data not found", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@CoachActivity, "Failed: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@CoachActivity, "Error: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
