package com.unsoed.responsi1mobileh1d023034.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unsoed.responsi1mobileh1d023034.data.model.Player
import com.unsoed.responsi1mobileh1d023034.data.network.RetrofitInstance
import com.unsoed.responsi1mobileh1d023034.utils.Constants
import kotlinx.coroutines.launch

class PlayerViewModel : ViewModel() {


    private val _players = MutableLiveData<List<Player>>()
    val players: LiveData<List<Player>> get() = _players


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage


    fun fetchPlayers() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = RetrofitInstance.api.getTeamById(
                    Constants.API_TOKEN,
                    Constants.TEAM_ID
                )

                if (response.isSuccessful) {
                    val team = response.body()
                    _players.value = team?.squad ?: emptyList()
                    Log.d("SUCCESS_GET_PLAYERS", "Total pemain: ${team?.squad?.size}")
                } else {
                    _errorMessage.value = "Gagal memuat data: ${response.code()}"
                    Log.e("API_ERROR", "${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.value = "Kesalahan: ${e.localizedMessage}"
                Log.e("EXCEPTION", e.localizedMessage ?: "Unknown error")
            } finally {
                _isLoading.value = false
            }
        }
    }
}
