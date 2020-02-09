package com.github.rougsig.meowflux.pokedex.network

import com.github.rougsig.meowflux.pokedex.entity.News
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {
  @GET("tabs/news")
  suspend fun getNews(@Query("_limit") limit: Int? = null): List<News>
}
