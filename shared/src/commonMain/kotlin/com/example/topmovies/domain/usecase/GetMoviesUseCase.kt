package com.example.topmovies.domain.usecase

import com.example.topmovies.domain.model.Movie
import com.example.topmovies.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMoviesUseCase: KoinComponent {

    private val repository: MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(page: Int): List<Movie> {
        return repository.getMovies(page = page)
    }
}