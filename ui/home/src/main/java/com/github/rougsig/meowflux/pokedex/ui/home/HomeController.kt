package com.github.rougsig.meowflux.pokedex.ui.home

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.github.rougsig.meowflux.core.Store
import com.github.rougsig.meowflux.pokedex.lib.core.instance
import com.github.rougsig.meowflux.pokedex.store.news.NewsAction
import com.github.rougsig.meowflux.pokedex.store.root.RootState
import com.github.rougsig.meowflux.pokedex.ui.core.BaseController
import kotlinx.android.synthetic.main.home_controller.*
import kotlinx.coroutines.flow.mapNotNull

class HomeController : BaseController() {
  override val viewLayout = R.layout.home_controller

  override fun initializeView(rootView: View) {
    val categories = CategoryEpoxyController(rootView.context)
    home_category_list.layoutManager = GridLayoutManager(rootView.context, 2)
    home_category_list.setItemSpacingDp(16)
    home_category_list.setControllerAndBuildModels(categories)

    val news = NewsEpoxyController(rootView.context)
    home_news_list.setController(news)

    val store = screenScope.instance<Store<RootState>>()
    store.dispatch(NewsAction.FetchNews)

    store.stateFlow
      .mapNotNull { it.news?.news }
      .observe { news.setData(it) }
  }
}
