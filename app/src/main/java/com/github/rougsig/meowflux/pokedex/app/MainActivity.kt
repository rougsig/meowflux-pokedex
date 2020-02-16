package com.github.rougsig.meowflux.pokedex.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.github.rougsig.meowflux.core.*
import com.github.rougsig.meowflux.pokedex.R
import com.github.rougsig.meowflux.pokedex.lib.core.closeForegroundScope
import com.github.rougsig.meowflux.pokedex.lib.core.instance
import com.github.rougsig.meowflux.pokedex.lib.core.openForegroundScope
import com.github.rougsig.meowflux.pokedex.network.NeworkModule
import com.github.rougsig.meowflux.pokedex.store.news.FetchNewsWatcher
import com.github.rougsig.meowflux.pokedex.store.root.RootState
import com.github.rougsig.meowflux.pokedex.store.root.rootReducer
import com.github.rougsig.meowflux.pokedex.store.routing.RoutingAction
import com.github.rougsig.meowflux.pokedex.ui.routing.RoutingWatcher
import com.github.rougsig.meowflux.worker.Watcher
import com.github.rougsig.meowflux.worker.WorkerContext
import com.github.rougsig.meowflux.worker.WorkerMiddleware
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import toothpick.config.Module
import javax.inject.Inject
import javax.inject.Provider

@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

  private val storeLogger: Middleware<RootState> = { _, _, _, next ->
    { action ->
      val threadId = Thread.currentThread().id
      println("STORE ($threadId): $action")
      next(action)
    }
  }

  private lateinit var store: Store<RootState>
  private lateinit var router: Router

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    router = Conductor.attachRouter(this, top_content_frame, savedInstanceState)

    openForegroundScope().installModules(
      object : Module() {
        init {
          bind(Router::class.java)
            .toInstance(router)

          bind(CoroutineScope::class.java)
            .toInstance(this@MainActivity)

          bind(WorkerMiddleware::class.java)
            .toProvider(WorkerMiddlewareProvider::class.java)
            .providesSingletonInScope()
        }
      },
      NeworkModule()
    )

    store = Store(
      reducer = rootReducer,
      initialState = RootState(),
      middleware = listOf(
        storeLogger,
        openForegroundScope().instance<WorkerMiddleware<RootState>>()
      )
    )

    openForegroundScope().installModules(
      object : Module() {
        init {
          bind(Store::class.java)
            .toInstance(store)
        }
      }
    )

    store.dispatch(RoutingAction.ShowHomeScreen)
  }

  override fun onBackPressed() {
    if (!router.handleBack()) {
      super.onBackPressed()
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    router.onActivityResult(requestCode, resultCode, data)
  }

  override fun onDestroy() {
    super.onDestroy()
    this.cancel()
    closeForegroundScope()
  }
}

@FlowPreview
@ExperimentalCoroutinesApi
private class WorkerMiddlewareProvider @Inject constructor(
  private val routing: RoutingWatcher,
  private val news: FetchNewsWatcher
) : Provider<WorkerMiddleware<RootState>> {
  override fun get(): WorkerMiddleware<RootState> {
    return WorkerMiddleware(listOf(routing, news))
  }
}
