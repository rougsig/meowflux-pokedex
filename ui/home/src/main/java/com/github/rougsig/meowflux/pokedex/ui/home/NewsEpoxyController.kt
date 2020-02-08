package com.github.rougsig.meowflux.pokedex.ui.home

import android.content.Context
import com.airbnb.epoxy.TypedEpoxyController
import com.github.rougsig.meowflux.pokedex.store.news.News
import com.github.rougsig.meowflux.pokedex.ui.core.component.dividerView
import com.github.rougsig.meowflux.pokedex.ui.core.component.newsItemView

internal class NewsEpoxyController(
  private val context: Context
) : TypedEpoxyController<List<News>>() {
  override fun buildModels(news: List<News>) {
    news.forEachIndexed { index, item ->
      newsItemView {
        id(index)
        title(item.title)
        date(item.date)
        image(item.imageUrl)
      }
      dividerView {
        id("divider_$index")
        color(R.color.divider)
        heightDp(1)
      }
    }
  }
}
