package br.com.raphael.punkapp.ui.view.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.raphael.punkapp.databinding.FragmentDetailsBinding
import br.com.raphael.punkapp.ui.base.BaseFragment

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLayout()
        setupListeners()
    }

    private fun setupLayout() {
        val beer = args.beer
        println("Beer $beer")
    }

    private fun setupListeners() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}