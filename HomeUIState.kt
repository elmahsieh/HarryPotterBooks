package com.ehsieh2.books20.models

data class HomeUIState(
    val books: List<Book> = BookTestData.books,
    val selectedBook: Book? = null,
    val showsDetail: Boolean = false
)