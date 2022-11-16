package br.com.raphael.punkapp.data.repository

import br.com.raphael.punkapp.data.model.response.BeerResponse
import retrofit2.Response

interface BeersRepository {
    suspend fun getBeers(page: Int, perPage: Int): Response<List<BeerResponse>>
}