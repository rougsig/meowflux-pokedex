package com.github.rougsig.meowflux.pokedex.ui.routing

import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.github.rougsig.meowflux.extension.createTypedMiddleware
import com.github.rougsig.meowflux.pokedex.lib.core.instance
import com.github.rougsig.meowflux.pokedex.lib.core.openForegroundScope
import com.github.rougsig.meowflux.pokedex.store.root.RootState
import com.github.rougsig.meowflux.pokedex.store.routing.RoutingAction
import com.github.rougsig.meowflux.pokedex.store.routing.RoutingAction.ShowHomeScreen
import com.github.rougsig.meowflux.pokedex.store.routing.RoutingAction.ShowNewsDetails
import com.github.rougsig.meowflux.pokedex.ui.core.extension.SCREEN_KEY_ARG_NAME
import com.github.rougsig.meowflux.pokedex.ui.home.HomeController
import com.github.rougsig.meowflux.pokedex.ui.news.details.NewsDetailsController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

val routingMiddleware = createTypedMiddleware<RoutingAction, RootState> { action, _, _, _ ->
  val router = openForegroundScope().instance<Router>()
  val uiScope = openForegroundScope().instance<CoroutineScope>()

  when (action) {
    is ShowHomeScreen -> uiScope.launch { router.setRoot(RouterTransaction.with(HomeController())) }
    is ShowNewsDetails -> uiScope.launch {
      val controller = NewsDetailsController()
      controller.args.putParcelable(SCREEN_KEY_ARG_NAME, action)
      router.pushController(RouterTransaction.with(controller))
    }
  }
}
