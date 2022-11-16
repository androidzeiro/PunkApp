package br.com.raphael.punkapp.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import br.com.raphael.punkapp.data.repository.BeersRepository
import br.com.raphael.punkapp.ui.view.paging.BeerPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeersViewModel @Inject constructor (
    private val beersRepository: BeersRepository
) : ViewModel() {

    val pagingFlow = Pager(
        PagingConfig(
            pageSize = BeerPagingSource.PER_PAGE,
            enablePlaceholders = false
        )
    ) {
        BeerPagingSource(beersRepository)
    }.flow.cachedIn(viewModelScope)

    fun getBeers() {
        viewModelScope.launch {
            beersRepository.getBeers(1, 2)
        }
    }
}