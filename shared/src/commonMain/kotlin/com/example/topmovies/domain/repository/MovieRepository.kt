package com.example.topmovies.domain.repository

import com.example.topmovies.domain.model.Movie

internal interface MovieRepository {

    suspend fun getMovies(page: Int): List<Movie>

    suspend fun getMovie(movieId: Int): Movie
}