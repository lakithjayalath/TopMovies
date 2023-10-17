package com.example.topmovies.data.repository

import com.example.topmovies.data.remote.RemoteDataSource
import com.example.topmovies.data.util.toMovie
import com.example.topmovies.domain.model.Movie
import com.example.topmovies.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page = page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId = movieId).toMovie()
    }
}