package com.github.rougsig.meowflux.pokedex.store.news

import com.github.rougsig.meowflux.extension.createTypedMiddleware
import com.github.rougsig.meowflux.pokedex.network.api
import com.github.rougsig.meowflux.pokedex.store.news.NewsAction.*
import com.github.rougsig.meowflux.pokedex.store.root.RootState

val newsFetcher = createTypedMiddleware<FetchNews, RootState> { _, dispatch, _, _ ->
  dispatch(Start)
  try {
    val news = api.getNews()
    dispatch(Success(news))
  } catch (e: Exception) {
    dispatch(Failure(e))
  }
}
