package com.example.shoestore.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentInstructionBinding>(
            inflater,
            R.layout.fragment_instruction,
            container,
            false
        )
        binding.toShoeListButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_instructionFragment_to_shoeListingFragment))
        return binding.root
    }
}