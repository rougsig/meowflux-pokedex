package com.github.rougsig.meowflux.pokedex.store.news

import com.github.rougsig.meowflux.core.Action
import com.github.rougsig.meowflux.pokedex.entity.News
import com.github.rougsig.meowflux.worker.CachedAction

sealed class NewsAction : Action {
  data class FetchNews(override val skipCache: Boolean = false) : CachedAction

  object Start : NewsAction()
  data class Success(val news: List<News>) : NewsAction()
  data class Failure(val error: Throwable) : NewsAction()
}
