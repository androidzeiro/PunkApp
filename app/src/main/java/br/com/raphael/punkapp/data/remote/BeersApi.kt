package br.com.raphael.punkapp.data.remote

import br.com.raphael.punkapp.data.model.response.BeerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BeersApi {

    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<List<BeerResponse>>
}