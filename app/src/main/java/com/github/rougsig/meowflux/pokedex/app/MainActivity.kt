package com.github.rougsig.meowflux.pokedex.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.github.rougsig.meowflux.core.BaseStore
import com.github.rougsig.meowflux.core.Store
import com.github.rougsig.meowflux.core.StoreDispatcher
import com.github.rougsig.meowflux.pokedex.R
import com.github.rougsig.meowflux.pokedex.lib.core.closeForegroundScope
import com.github.rougsig.meowflux.pokedex.lib.core.openForegroundScope
import com.github.rougsig.meowflux.pokedex.store.news.newsFetcher
import com.github.rougsig.meowflux.pokedex.store.root.RootState
import com.github.rougsig.meowflux.pokedex.store.root.rootReducer
import com.github.rougsig.meowflux.pokedex.ui.home.HomeController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import toothpick.config.Module

@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

  private val store = BaseStore(
    storeScope = this,
    reducer = rootReducer,
    initialState = RootState(),
    middlewares = listOf(
      newsFetcher,
      { _, _, next ->
        { action ->
          println("STORE: $action")
          next(action)
        }
      }
    ),
    storeName = "MeowFluxRootStore"
  )
  private lateinit var router: Router

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    router = Conductor.attachRouter(this, top_content_frame, savedInstanceState)

    openForegroundScope().installModules(object : Module() {
      init {
        bind(Store::class.java)
          .toInstance(store)

        bind(StoreDispatcher::class.java)
          .toInstance(store)

        bind(Router::class.java)
          .toInstance(router)

        bind(CoroutineScope::class.java)
          .toInstance(this@MainActivity)
      }
    })

    router.setRoot(RouterTransaction.with(HomeController()))
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
