package com.github.rougsig.meowflux.pokedex.store.root

import com.github.rougsig.meowflux.core.Action
import com.github.rougsig.meowflux.pokedex.store.news.NewsState
import com.github.rougsig.meowflux.pokedex.store.news.newsReducer

data class RootState(
  val news: NewsState? = null
)

val rootReducer = { action: Action, previousState: RootState? ->
  RootState(
    news = newsReducer(action, previousState?.news)
  )
}
