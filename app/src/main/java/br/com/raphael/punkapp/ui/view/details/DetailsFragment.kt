package br.com.raphael.punkapp.ui.view.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import br.com.raphael.punkapp.databinding.FragmentDetailsBinding
import br.com.raphael.punkapp.ui.base.BaseFragment

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("Beer: ${args.beer}")
    }
}