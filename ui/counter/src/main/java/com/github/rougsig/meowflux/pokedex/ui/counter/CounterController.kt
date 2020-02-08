package com.github.rougsig.meowflux.pokedex.ui.counter

import android.view.View
import com.github.rougsig.meowflux.core.Store
import com.github.rougsig.meowflux.pokedex.lib.core.instance
import com.github.rougsig.meowflux.pokedex.store.counter.CounterAction.Decrement
import com.github.rougsig.meowflux.pokedex.store.counter.CounterAction.Increment
import com.github.rougsig.meowflux.pokedex.store.root.RootState
import com.github.rougsig.meowflux.pokedex.ui.core.BaseController
import kotlinx.android.synthetic.main.counter_controller.*
import kotlinx.coroutines.flow.mapNotNull

class CounterController : BaseController() {
  override val viewLayout = R.layout.counter_controller

  override fun initializeView(rootView: View) {
    val store = screenScope.instance<Store<RootState>>()

    counter_plus.setOnClickListener {
      store.dispatch(Increment)
    }

    counter_minus.setOnClickListener {
      store.dispatch(Decrement)
    }

    store.stateFlow
      .mapNotNull { it.counterState?.count }
      .observe { count ->
        counter_counter.text = count.toString()
      }
  }
}
