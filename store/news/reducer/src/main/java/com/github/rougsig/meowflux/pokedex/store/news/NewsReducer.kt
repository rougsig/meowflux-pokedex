package com.github.rougsig.meowflux.pokedex.store.news

import com.github.rougsig.meowflux.extension.TypedReducer
import com.github.rougsig.meowflux.pokedex.store.news.NewsAction.*

val newsReducer = TypedReducer(NewsState()) { action: NewsAction, previousState ->
  when (action) {
    is Start -> previousState.copy(
      isLoading = true
    )
    is Success -> previousState.copy(
      isLoading = false,
      news = action.news
    )
    is Failure -> previousState.copy(
      isLoading = false,
      error = action.error
    )
  }
}
