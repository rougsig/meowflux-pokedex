package com.github.rougsig.meowflux.pokedex.store.news

import com.github.rougsig.meowflux.extension.createTypedReducer
import com.github.rougsig.meowflux.pokedex.store.news.NewsAction.*

val newsReducer = createTypedReducer(NewsState()) { action: NewsAction, previousState ->
  when (action) {
    is FetchNews -> previousState
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
