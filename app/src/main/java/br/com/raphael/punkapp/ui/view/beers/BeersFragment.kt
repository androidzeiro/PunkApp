package br.com.raphael.punkapp.ui.view.beers

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.raphael.punkapp.databinding.FragmentBeersBinding
import br.com.raphael.punkapp.ui.base.BaseFragment
import br.com.raphael.punkapp.ui.view.adapter.BeerPagingDataAdapter
import br.com.raphael.punkapp.ui.view.viewmodel.BeersViewModel
import br.com.raphael.punkapp.util.extension.isInternetAvailable
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class BeersFragment : BaseFragment<FragmentBeersBinding>(FragmentBeersBinding::inflate) {

    private val beersViewModel: BeersViewModel by viewModels()

    private val beersAdapter: BeerPagingDataAdapter by lazy {
        BeerPagingDataAdapter { beer ->
            println(beer)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLayout()
        callApi()
    }

    private fun setupLayout() {
        binding.recyclerBeers.layoutManager = LinearLayoutManager(context)
        binding.recyclerBeers.adapter = beersAdapter

        beersAdapter.addLoadStateListener { loadState ->
            binding.layoutRetry.root.isVisible = loadState.refresh is LoadState.NotLoading && beersAdapter.itemCount == 0
            binding.layoutRetry.buttonRetry.setOnClickListener {
                beersAdapter.retry()
            }
            binding.progress.isVisible = loadState.refresh is LoadState.Loading && beersAdapter.itemCount == 0
        }
    }

    private fun callApi() {
        if (requireContext().isInternetAvailable()) {
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                beersViewModel.pagingFlow.collectLatest { pagingData ->
                    binding.progress.visibility = View.INVISIBLE
                    beersAdapter.submitData(pagingData)
                }
            }
        } else {
            binding.layoutRetry.root.isVisible = true
            binding.layoutRetry.buttonRetry.setOnClickListener {
                callApi()
            }
        }
    }
}