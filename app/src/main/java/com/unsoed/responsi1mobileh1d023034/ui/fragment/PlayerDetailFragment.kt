package com.unsoed.responsi1mobileh1d023034.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.unsoed.responsi1mobileh1d023034.R
import com.unsoed.responsi1mobileh1d023034.databinding.FragmentPlayerDetailBinding

class PlayerDetailFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentPlayerDetailBinding? = null
    private val binding get() = _binding!!

    private var name: String? = null
    private var position: String? = null
    private var nationality: String? = null
    private var birth: String? = null

    override fun getTheme(): Int = R.style.ThemeOverlay_App_BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
            position = it.getString(ARG_POSITION)
            nationality = it.getString(ARG_NATIONALITY)
            birth = it.getString(ARG_BIRTH)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {
        binding.tvPlayerName.text = name ?: "Unknown Player"
        binding.tvPlayerPosition.text = position ?: "-"
        binding.tvPlayerNationality.text = nationality ?: "-"
        binding.tvPlayerBirth.text = birth ?: "-"

        Glide.with(this)
            .load(R.drawable.ic_pemainn)
            .into(binding.imgPlayer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_NAME = "name"
        private const val ARG_POSITION = "position"
        private const val ARG_NATIONALITY = "nationality"
        private const val ARG_BIRTH = "birth"

        fun newInstance(name: String, position: String, nationality: String, birth: String) =
            PlayerDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_POSITION, position)
                    putString(ARG_NATIONALITY, nationality)
                    putString(ARG_BIRTH, birth)
                }
            }
    }
}
