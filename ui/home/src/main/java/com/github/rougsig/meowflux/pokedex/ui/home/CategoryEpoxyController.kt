package com.github.rougsig.meowflux.pokedex.ui.home

import android.content.Context
import com.airbnb.epoxy.EpoxyController
import com.github.rougsig.meowflux.pokedex.ui.core.component.categoryItemView

internal class CategoryEpoxyController(
  private val context: Context
) : EpoxyController() {
  override fun buildModels() {
    categoryItemView {
      id(R.string.category_item_1)
      title(context.getString(R.string.category_item_1))
      cardBackground(R.color.lightTeal)
      background(R.color.white)
    }
    categoryItemView {
      id(R.string.category_item_2)
      title(context.getString(R.string.category_item_2))
      cardBackground(R.color.lightRed)
      background(R.color.white)
    }
    categoryItemView {
      id(R.string.category_item_3)
      title(context.getString(R.string.category_item_3))
      cardBackground(R.color.lightBlue)
      background(R.color.white)
    }
    categoryItemView {
      id(R.string.category_item_4)
      title(context.getString(R.string.category_item_4))
      cardBackground(R.color.lightYellow)
      background(R.color.white)
    }
    categoryItemView {
      id(R.string.category_item_5)
      title(context.getString(R.string.category_item_5))
      cardBackground(R.color.lightPurple)
      background(R.color.white)
    }
    categoryItemView {
      id(R.string.category_item_6)
      title(context.getString(R.string.category_item_6))
      cardBackground(R.color.lightBrown)
      background(R.color.white)
    }
  }
}
