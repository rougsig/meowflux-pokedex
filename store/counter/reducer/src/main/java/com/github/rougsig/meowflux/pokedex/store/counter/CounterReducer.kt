package com.github.rougsig.meowflux.pokedex.store.counter

import com.github.rougsig.meowflux.extension.createTypedReducer
import com.github.rougsig.meowflux.pokedex.store.counter.CounterAction.Decrement
import com.github.rougsig.meowflux.pokedex.store.counter.CounterAction.Increment

data class CounterState(
  val count: Int = 0
)

val counterReducer = createTypedReducer(CounterState()) { action: CounterAction, previousState ->
  when (action) {
    Increment -> previousState.copy(
      count = previousState.count + 1
    )
    Decrement -> previousState.copy(
      count = previousState.count - 1
    )
  }
}
