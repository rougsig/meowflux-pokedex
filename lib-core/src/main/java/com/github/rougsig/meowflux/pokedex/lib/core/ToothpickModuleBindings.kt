package com.github.rougsig.meowflux.pokedex.lib.core

import toothpick.config.Module

interface ToothpickModuleBindings {
  fun bindInto(module: Module)
}

object ToothpickEmptyModuleBindings : ToothpickModuleBindings {
  override fun bindInto(module: Module) = Unit
}

@Suppress("FunctionName")
inline fun ToothpickBindings(crossinline init: Module.() -> Unit): ToothpickModuleBindings {
  return object : ToothpickModuleBindings {
    override fun bindInto(module: Module) = init(module)
  }
}
