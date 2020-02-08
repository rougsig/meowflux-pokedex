package com.github.rougsig.meowflux.pokedex.store.counter

import com.github.rougsig.meowflux.core.Action

sealed class CounterAction : Action {
  object Increment : CounterAction()
  object Decrement : CounterAction()
}
