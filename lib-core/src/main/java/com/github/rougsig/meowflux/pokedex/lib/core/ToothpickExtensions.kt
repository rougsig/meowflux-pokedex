package com.github.rougsig.meowflux.pokedex.lib.core

import toothpick.Scope
import toothpick.Toothpick

const val FOREGROUND_SCOPE = "FOREGROUND_SCOPE"

fun openForegroundScope(): Scope {
  return Toothpick.openScope(FOREGROUND_SCOPE)
}

fun closeForegroundScope() {
  Toothpick.closeScope(FOREGROUND_SCOPE)
}

inline fun <reified T> Scope.instance(): T {
  return getInstance(T::class.java)
}
