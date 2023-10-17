package com.example.topmovies.di

import com.example.topmovies.data.remote.MovieService
import com.example.topmovies.data.remote.RemoteDataSource
import com.example.topmovies.data.repository.MovieRepositoryImpl
import com.example.topmovies.domain.repository.MovieRepository
import com.example.topmovies.domain.usecase.GetMovieUseCase
import com.example.topmovies.domain.usecase.GetMoviesUseCase
import com.example.topmovies.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModules