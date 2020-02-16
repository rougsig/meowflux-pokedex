package com.github.rougsig.meowflux.pokedex.ui.routing

import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.github.rougsig.meowflux.pokedex.store.root.RootState
import com.github.rougsig.meowflux.pokedex.store.routing.RoutingAction
import com.github.rougsig.meowflux.pokedex.store.routing.RoutingAction.ShowHomeScreen
import com.github.rougsig.meowflux.pokedex.store.routing.RoutingAction.ShowNewsDetails
import com.github.rougsig.meowflux.pokedex.ui.core.extension.SCREEN_KEY_ARG_NAME
import com.github.rougsig.meowflux.pokedex.ui.home.HomeController
import com.github.rougsig.meowflux.pokedex.ui.news.details.NewsDetailsController
import com.github.rougsig.meowflux.worker.Watcher
import com.github.rougsig.meowflux.worker.Worker
import com.github.rougsig.meowflux.worker.watcher
import com.github.rougsig.meowflux.worker.worker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoutingMiddleware @Inject constructor(
  private val router: Router
) : Worker<RoutingAction, RootState> by worker({ action ->
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
})

class RoutingWatcher(
  private val worker: Worker<RoutingAction, RootState>
) : Watcher<RoutingAction, RootState> by watcher(worker, {
  mapNotNull { it as? RoutingAction }
})
