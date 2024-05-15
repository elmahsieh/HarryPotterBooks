package com.ehsieh2.books20.models

data class Book(
    val index: Int,
    val title: String,
    val author: String,
    val released: String,
    val quote: String,
    val synopsis: String,
    val coverImage: Int,
)

