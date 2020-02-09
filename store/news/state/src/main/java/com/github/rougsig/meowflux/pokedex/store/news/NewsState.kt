package com.github.rougsig.meowflux.pokedex.store.news

import com.github.rougsig.meowflux.pokedex.entity.News

data class NewsState(
  val isLoading: Boolean = false,
  val error: Throwable? = null,
  val news: List<News>? = null
)
