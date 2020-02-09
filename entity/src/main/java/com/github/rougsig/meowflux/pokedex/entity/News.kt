package com.github.rougsig.meowflux.pokedex.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class News(
  val title: String,
  val date: String,
  val imageUrl: String,
  val text: String
)
