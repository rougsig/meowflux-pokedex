package com.github.rougsig.meowflux.pokedex.store.root

import com.github.rougsig.meowflux.core.Action
import com.github.rougsig.meowflux.pokedex.store.counter.CounterState
import com.github.rougsig.meowflux.pokedex.store.counter.counterReducer

data class RootState(
  val counterState: CounterState? = null
)

val rootReducer = { action: Action, previousState: RootState? ->
  RootState(
    counterState = counterReducer(action, previousState?.counterState)
  )
}
