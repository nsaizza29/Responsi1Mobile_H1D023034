package com.unsoed.responsi1mobileh1d023034

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsoed.responsi1mobileh1d023034.data.model.Player
import com.unsoed.responsi1mobileh1d023034.databinding.ActivityDaftarPlayerBinding
import com.unsoed.responsi1mobileh1d023034.ui.adapter.PlayerAdapter
import com.unsoed.responsi1mobileh1d023034.ui.adapter.OnPlayerClickListener
import com.unsoed.responsi1mobileh1d023034.ui.fragment.PlayerDetailFragment
import com.unsoed.responsi1mobileh1d023034.viewmodel.PlayerViewModel

class DaftarPlayerActivity : AppCompatActivity(), OnPlayerClickListener {

    private lateinit var binding: ActivityDaftarPlayerBinding
    private val viewModel: PlayerViewModel by viewModels()
    private lateinit var adapter: PlayerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PlayerAdapter(emptyList(), this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.players.observe(this) { players ->
            adapter.setData(players)
        }

        viewModel.errorMessage.observe(this) { msg ->
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        viewModel.fetchPlayers()
    }

    override fun onPlayerClick(player: Player) {
        PlayerDetailFragment.newInstance(
            player.name ?: "-",
            player.position ?: "-",
            player.nationality ?: "-",
            player.dateOfBirth ?: "-"
        ).show(supportFragmentManager, PlayerDetailFragment::class.java.simpleName)
    }
}
