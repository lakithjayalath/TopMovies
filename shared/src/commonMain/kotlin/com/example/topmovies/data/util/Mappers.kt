package com.example.topmovies.data.util

import com.example.topmovies.data.remote.MovieRemote
import com.example.topmovies.domain.model.Movie

internal fun MovieRemote.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        description = overview,
        imageUrl = getImageUrl(posterImage),
        releaseDate = releaseDate
    )
}

private fun getImageUrl(posterImage: String) = "https://image.tmbd.org"