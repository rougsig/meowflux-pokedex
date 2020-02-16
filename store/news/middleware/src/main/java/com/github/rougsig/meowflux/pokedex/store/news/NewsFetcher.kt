package com.github.rougsig.meowflux.pokedex.store.news

import com.github.rougsig.meowflux.pokedex.network.PokemonApi
import com.github.rougsig.meowflux.pokedex.store.news.NewsAction.*
import com.github.rougsig.meowflux.pokedex.store.root.RootState
import com.github.rougsig.meowflux.worker.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.delayEach
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class NewsFetcher @Inject constructor(
  private val api: PokemonApi
) : Worker<FetchNews, RootState> by worker({
  put(Start)
  try {
    val news = api.getNews()
    put(Success(news))
  } catch (e: Throwable) {
    put(Failure(e))
  }
})

class FetchNewsWatcher @Inject constructor(
  private val worker: NewsFetcher
) : Watcher<FetchNews, RootState> by cachedWatcher(worker, select = {
  mapNotNull { it as? FetchNews }
})
