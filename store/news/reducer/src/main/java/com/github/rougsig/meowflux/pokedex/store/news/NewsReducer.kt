package com.github.rougsig.meowflux.pokedex.store.news

import com.github.rougsig.meowflux.extension.createTypedReducer

val newsReducer = createTypedReducer(NewsState()) { action: NewsAction, previousState ->
  when (action) {
    is NewsAction.FetchNews -> previousState
    is NewsAction.Start -> previousState.copy(
      isLoading = true
    )
    is NewsAction.Success -> previousState.copy(
      news = action.news
    )
    is NewsAction.Failure -> previousState.copy(
      isLoading = false,
      error = action.error
    )
  }
}
