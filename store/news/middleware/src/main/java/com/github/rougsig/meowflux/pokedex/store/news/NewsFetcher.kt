package com.github.rougsig.meowflux.pokedex.store.news

import com.github.rougsig.meowflux.pokedex.network.api
import com.github.rougsig.meowflux.pokedex.store.news.NewsAction.*
import com.github.rougsig.meowflux.pokedex.store.root.RootState
import com.github.rougsig.meowflux.worker.takeEvery

val newsFetcher = takeEvery<FetchNews, RootState> {
  put(Start)
  try {
    val news = api.getNews()
    put(Success(news))
  } catch (e: Exception) {
    put(Failure(e))
  }
}
