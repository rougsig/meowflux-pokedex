package com.github.rougsig.meowflux.pokedex.store.news

import com.github.rougsig.meowflux.core.Action
import com.github.rougsig.meowflux.pokedex.entity.News

sealed class NewsAction : Action {
  object FetchNews : NewsAction()

  object Start : NewsAction()
  data class Success(val news: List<News>) : NewsAction()
  data class Failure(val error: Throwable) : NewsAction()
}
