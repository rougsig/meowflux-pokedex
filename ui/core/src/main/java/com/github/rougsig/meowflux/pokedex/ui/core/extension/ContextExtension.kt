package com.github.rougsig.meowflux.pokedex.ui.core.extension

import android.content.Context
import android.util.TypedValue
import androidx.annotation.DrawableRes

@DrawableRes
fun Context.getSelectableItemBackgroundResource(): Int {
  val tv = TypedValue()
  theme.resolveAttribute(android.R.attr.selectableItemBackground, tv, true)
  return tv.resourceId
}

@DrawableRes
fun Context.getSelectableItemBackgroundBorderlessResource(): Int {
  val tv = TypedValue()
  theme.resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, tv, true)
  return tv.resourceId
}
