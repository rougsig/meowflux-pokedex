package com.github.rougsig.meowflux.pokedex.ui.core.extension

import android.view.View

fun View.setSelectableItemBackground() {
  setBackgroundResource(context.getSelectableItemBackgroundResource())
}

fun View.setSelectableItemBackgroundBorderless() {
  setBackgroundResource(context.getSelectableItemBackgroundBorderlessResource())
}
