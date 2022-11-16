package br.com.raphael.punkapp.ui.view.beers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import br.com.raphael.punkapp.databinding.FragmentBeersBinding
import br.com.raphael.punkapp.ui.base.BaseFragment
import br.com.raphael.punkapp.ui.view.viewmodel.BeersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeersFragment : BaseFragment<FragmentBeersBinding>(FragmentBeersBinding::inflate) {

    private val beersViewModel: BeersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        beersViewModel.getBeers()
    }
}