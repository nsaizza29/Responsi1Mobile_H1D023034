package com.unsoed.responsi1mobileh1d023034.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unsoed.responsi1mobileh1d023034.data.model.Player
import com.unsoed.responsi1mobileh1d023034.databinding.ListPlayerBinding

class PlayerAdapter(
    private var players: List<Player>,
    private val listener: OnPlayerClickListener
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(val binding: ListPlayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ListPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun getItemCount(): Int = players.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]


        holder.binding.apply {
            tvPlayerName.text = player.name ?: "No Name"
            tvPlayerPosition.text = player.position ?: "-"
            tvPlayerNationality.text = player.nationality ?: "-"
            tvPlayerBirth.text = player.dateOfBirth ?: "-"
        }

        val bgColor = when (player.position?.lowercase()) {
            "goalkeeper" -> Color.parseColor("#FFF59D") // kuning
            "defence", "defender" -> Color.parseColor("#90CAF9") // biru
            "midfield", "midfielder" -> Color.parseColor("#A5D6A7") // hijau
            "offence", "forward" -> Color.parseColor("#EF9A9A") // merah
            else -> Color.parseColor("#E0E0E0") // abu default
        }

        holder.binding.cardPlayer.setCardBackgroundColor(bgColor)


        holder.binding.root.setOnClickListener {
            listener.onPlayerClick(player)
        }
    }


    fun setData(newPlayers: List<Player>) {
        players = newPlayers
        notifyDataSetChanged()
    }
}

// interface klik item pemain
interface OnPlayerClickListener {
    fun onPlayerClick(player: Player)
}
