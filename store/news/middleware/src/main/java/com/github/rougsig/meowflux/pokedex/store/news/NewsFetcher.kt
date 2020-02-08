package com.github.rougsig.meowflux.pokedex.store.news

import com.github.rougsig.meowflux.core.Middleware
import com.github.rougsig.meowflux.pokedex.store.news.NewsAction.*
import com.github.rougsig.meowflux.pokedex.store.root.RootState

val newsFetcher: Middleware<RootState> = { root, _, next ->
  { action ->
    if (action is FetchNews) {
      root(Start)
      try {
        root(Success(List(4) {
          News(
            title = "Pokémon Rumble Rush Arrives Soon",
            date = "15 May 2019",
            imageUrl = "https://raw.githubusercontent.com/mrcsxsiq/Kotlin-Pokedex/master/app/src/main/res/drawable/news1.png",
            text = """
              |Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
              |incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud 
              |exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
              |
              |Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu 
              |fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in 
              |culpa qui officia deserunt mollit anim id est laborum.
              """.trimIndent()
          )
        }))
      } catch (e: Exception) {
        root(Failure(Throwable("emulating network request error")))
      }
    } else {
      next(action)
    }
  }
}
