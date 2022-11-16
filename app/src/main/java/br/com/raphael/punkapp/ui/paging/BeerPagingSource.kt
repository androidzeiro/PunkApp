package br.com.raphael.punkapp.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.raphael.punkapp.data.model.response.BeerResponse
import br.com.raphael.punkapp.data.repository.BeersRepository

class BeerPagingSource(
    private val beersRepository: BeersRepository
) : PagingSource<Int, BeerResponse>() {

    override fun getRefreshKey(state: PagingState<Int, BeerResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BeerResponse> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = beersRepository.getBeers(
                page,
                PER_PAGE
            )

            LoadResult.Page(
                data = response.body() ?: mutableListOf(),
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.body()?.isEmpty() == true) null else page.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
        const val PER_PAGE = 10
    }
}