package com.example.shoestore.screen.shoelisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListingBinding
import com.example.shoestore.databinding.ShoeViewBinding
import com.example.shoestore.models.Shoe
import com.example.shoestore.screen.login.LoginViewModel

class ShoeListingFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeListingFragment()
    }
    private lateinit var viewModel: ShoeListingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeListingBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[ShoeListingViewModel::class.java]
        viewModel.shoes.observe(viewLifecycleOwner) {
            run {
                binding.listShoe.removeAllViews()
                for (shoe in it) {
                    binding.listShoe.addView(createShoeView(shoe, container, inflater))
                }
            }
        }
        return binding.root
    }

    private fun createShoeView(
        shoe: Shoe,
        container: ViewGroup?,
        inflater: LayoutInflater,
    ): View {
        val view: ShoeViewBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoe_view, container, false)
        view.shoeNameText.text = "Name: ${shoe.name}"
        view.shoeSizeText.text = "Size: ${shoe.size}"
        view.shoeCompanyText.text = "Company: ${shoe.company}"
        view.shoeDescriptionText.text = "Description: ${shoe.description}"
        return view.root
    }

}