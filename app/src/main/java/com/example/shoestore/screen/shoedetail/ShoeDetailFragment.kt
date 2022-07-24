package com.example.shoestore.screen.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeDetailBinding
import com.example.shoestore.models.Shoe
import com.example.shoestore.screen.shoelisting.ShoeShareViewModel

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var shoeViewModel: ShoeShareViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.lifecycleOwner = this
        shoeViewModel = ViewModelProvider(requireActivity())[ShoeShareViewModel::class.java]
        binding.shoeViewModel = shoeViewModel
        binding.shoe = Shoe()
        binding.cancelButton.setOnClickListener { canCel() }
        binding.saveShoeButton.setOnClickListener { addShoe() }
        return binding.root
    }

    private fun addShoe() {
        shoeViewModel.addShoe(binding.shoe!!)
        view!!.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListingFragment)
    }


    private fun canCel() {
        view!!.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListingFragment)
    }
}
