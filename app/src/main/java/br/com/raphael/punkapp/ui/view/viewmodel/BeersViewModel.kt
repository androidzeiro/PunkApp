package br.com.raphael.punkapp.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.raphael.punkapp.data.repository.BeersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeersViewModel @Inject constructor (
    private val beersRepository: BeersRepository
) : ViewModel() {

    fun getBeers() {
        viewModelScope.launch {
            beersRepository.getBeers(1, 2)
        }
    }
}