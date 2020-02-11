package com.github.rougsig.meowflux.pokedex.ui.routing

import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.github.rougsig.meowflux.pokedex.lib.core.instance
import com.github.rougsig.meowflux.pokedex.lib.core.openForegroundScope
import com.github.rougsig.meowflux.pokedex.store.root.RootState
import com.github.rougsig.meowflux.pokedex.store.routing.RoutingAction
import com.github.rougsig.meowflux.pokedex.store.routing.RoutingAction.ShowHomeScreen
import com.github.rougsig.meowflux.pokedex.store.routing.RoutingAction.ShowNewsDetails
import com.github.rougsig.meowflux.pokedex.ui.core.extension.SCREEN_KEY_ARG_NAME
import com.github.rougsig.meowflux.pokedex.ui.home.HomeController
import com.github.rougsig.meowflux.pokedex.ui.news.details.NewsDetailsController
import com.github.rougsig.meowflux.worker.takeEvery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

val router by lazy { openForegroundScope().instance<Router>() }

val routingMiddleware = takeEvery<RoutingAction, RootState> { action ->
  withContext(Dispatchers.Main) {
    when (action) {
      is ShowHomeScreen -> {
        router.setRoot(RouterTransaction.with(HomeController()))
      }
      is ShowNewsDetails -> {
        val controller = NewsDetailsController()
        controller.args.putParcelable(SCREEN_KEY_ARG_NAME, action)
        router.pushController(RouterTransaction.with(controller))
      }
    }
  }
}
