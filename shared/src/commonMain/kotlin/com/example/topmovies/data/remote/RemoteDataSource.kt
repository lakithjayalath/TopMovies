package com.example.topmovies.data.remote

import com.example.topmovies.util.Dispatcher
import kotlinx.coroutines.withContext

// providing the remote data to the repository and as well as switching the network call to a different thread
internal class RemoteDataSource(
    private val apiService: MovieService,
    private val dispatcher: Dispatcher
) {
    suspend fun getMovies(page: Int) = withContext(dispatcher.io) {
        apiService.getMovies(page = page)
    }

    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io) {
        apiService.getMovie(movieId = movieId)
    }
}