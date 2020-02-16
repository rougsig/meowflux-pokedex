package com.github.rougsig.meowflux.pokedex.store.news

import com.github.rougsig.meowflux.pokedex.network.PokemonApi
import com.github.rougsig.meowflux.pokedex.store.news.NewsAction.*
import com.github.rougsig.meowflux.pokedex.store.root.RootState
import com.github.rougsig.meowflux.worker.Watcher
import com.github.rougsig.meowflux.worker.Worker
import com.github.rougsig.meowflux.worker.cachedWatcher
import com.github.rougsig.meowflux.worker.worker
import kotlinx.coroutines.flow.mapNotNull
import org.threeten.bp.Duration
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

class FetchNewsWatcher(
  private val worker: Worker<FetchNews, RootState>
) : Watcher<FetchNews, RootState> by cachedWatcher(worker, {
  mapNotNull { it as? FetchNews }
}, Duration.ofMinutes(10L))
