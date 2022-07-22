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

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        viewModel = ViewModelProvider(this)[ShoeDetailViewModel::class.java]
        binding.shoeDetail = viewModel
        binding.cancelButton.setOnClickListener { canCel() }
        binding.saveShoeButton.setOnClickListener { addShoe() }
        return binding.root
    }

    fun addShoe() {
        view!!.findNavController().navigate(
            ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment(
                viewModel.shoeName.value ?: "",
                viewModel.shoeSize.value ?: 0.0f,
                viewModel.shoeCompany.value ?: "",
                viewModel.shoeDescription.value ?: "",
            )
        )
    }

    fun canCel() {
        view!!.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListingFragment)
    }
}
