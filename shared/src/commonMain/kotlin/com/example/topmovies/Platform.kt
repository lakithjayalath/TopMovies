package com.example.topmovies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform