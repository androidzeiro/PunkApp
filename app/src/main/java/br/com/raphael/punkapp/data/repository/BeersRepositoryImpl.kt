package br.com.raphael.punkapp.data.repository

import br.com.raphael.punkapp.data.model.response.BeerResponse
import br.com.raphael.punkapp.data.remote.BeersApi
import retrofit2.Response
import javax.inject.Inject

class BeersRepositoryImpl @Inject constructor(
    private val beersApi: BeersApi
) : BeersRepository {

    override suspend fun getBeers(page: Int, perPage: Int): Response<List<BeerResponse>> {
        return beersApi.getBeers(page, perPage)
    }
}