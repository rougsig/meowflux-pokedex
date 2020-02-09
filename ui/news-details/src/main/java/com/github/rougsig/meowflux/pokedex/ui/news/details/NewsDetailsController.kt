package com.github.rougsig.meowflux.pokedex.ui.news.details

import android.view.View
import com.github.rougsig.meowflux.core.Store
import com.github.rougsig.meowflux.pokedex.lib.core.instance
import com.github.rougsig.meowflux.pokedex.store.root.RootState
import com.github.rougsig.meowflux.pokedex.store.routing.RoutingAction
import com.github.rougsig.meowflux.pokedex.ui.core.BaseController
import com.github.rougsig.meowflux.pokedex.ui.core.extension.key
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_details_controller.*
import kotlinx.coroutines.flow.mapNotNull

class NewsDetailsController : BaseController() {
  override val viewLayout = R.layout.news_details_controller

  override fun initializeView(rootView: View) {
    val store = screenScope.instance<Store<RootState>>()
    val newsId = key<RoutingAction.ShowNewsDetails>().newsId

    store.stateFlow
      .mapNotNull { it.news?.news?.get(newsId) }
      .observe { news ->
        Picasso.get().load(news.imageUrl).into(news_details_image)
        news_details_title.text = news.title
        news_details_date.text = news.date
        news_details_text.text = news.text
      }
  }
}
