package com.github.rougsig.meowflux.pokedex.store.news

data class NewsState(
  val isLoading: Boolean = false,
  val error: Throwable? = null,
  val news: List<News>? = null
)
