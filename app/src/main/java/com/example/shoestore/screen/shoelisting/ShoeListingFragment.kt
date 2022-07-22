package com.example.shoestore.screen.shoelisting

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListingBinding
import com.example.shoestore.databinding.ShoeViewBinding
import com.example.shoestore.models.Shoe

class ShoeListingFragment : Fragment() {
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
        try {
            val args = ShoeListingFragmentArgs.fromBundle(requireArguments())
            viewModel.addShoe(args)
        } catch (e: IllegalArgumentException) {
        }
        viewModel.shoes.observe(viewLifecycleOwner) {
            run {
                binding.listShoe.removeAllViews()
                for (shoe in it) {
                    binding.listShoe.addView(createShoeView(shoe, container, inflater))
                }
            }
        }
        binding.addShoeButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListingFragment_to_shoeDetailFragment))
        addMenuProvider()
        return binding.root
    }

    private fun addMenuProvider() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.shoe_listing_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.logout -> {
                        view?.findNavController()!!
                            .navigate(R.id.action_shoeListingFragment_to_loginFragment)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
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