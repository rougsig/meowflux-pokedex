package com.github.rougsig.meowflux.pokedex.ui.core.extension

import android.os.Parcelable
import com.bluelinelabs.conductor.Controller

const val SCREEN_KEY_ARG_NAME = "SCREEN_KEY_ARG_NAME"

fun <T : Parcelable> Controller.key(): T {
  return args.getParcelable(SCREEN_KEY_ARG_NAME)
    ?: error("controller was not constructed with key")
}
