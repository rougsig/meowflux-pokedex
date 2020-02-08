package com.github.rougsig.meowflux.pokedex.ui.core

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.github.rougsig.meowflux.pokedex.lib.core.FOREGROUND_SCOPE
import com.github.rougsig.meowflux.pokedex.lib.core.ToothpickEmptyModuleBindings
import com.github.rougsig.meowflux.pokedex.lib.core.ToothpickModuleBindings
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import toothpick.Scope
import toothpick.Toothpick
import toothpick.config.Module
import java.util.*

abstract class BaseController : Controller, LayoutContainer {
  private var bindPropsRootView: View? = null
  protected abstract val viewLayout: Int

  protected val screenBindings: ToothpickModuleBindings = ToothpickEmptyModuleBindings
  protected lateinit var screenScope: Scope
    private set

  protected lateinit var coroutineScope: CoroutineScope
    private set

  constructor()
  constructor(args: Bundle) : super(args)

  final override fun onContextAvailable(context: Context) {
    super.onContextAvailable(context)

    val scopeName = this.javaClass.simpleName + "_" + UUID.randomUUID().toString()
    screenScope = Toothpick.openScopes(FOREGROUND_SCOPE, scopeName)

    val screenModule = Module()
    screenBindings.bindInto(screenModule)
    screenScope.installModules(screenModule)
  }

  final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    coroutineScope = MainScope()
    val rootView = inflater.inflate(viewLayout, container, false)
    bindPropsRootView = rootView
    initializeView(rootView)
    return rootView
  }

  abstract fun initializeView(rootView: View)

  override val containerView: View?
    get() = bindPropsRootView

  override fun onDestroyView(view: View) {
    coroutineScope.cancel()
    clearFindViewByIdCache()
    bindPropsRootView = null
    super.onDestroyView(view)
  }

  override fun onDestroy() {
    super.onDestroy()
    Toothpick.closeScope(screenScope.name)
  }

  protected fun <T> Flow<T>.observe(action: (T) -> Unit) {
    coroutineScope.launch {
      collect { action(it) }
    }
  }
}
