package com.github.rougsig.meowflux.pokedex.ui.core.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.view.updateLayoutParams
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.github.rougsig.meowflux.pokedex.ui.core.extension.dpToPx

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class DividerView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

  @ModelProp
  fun setHeightDp(height: Int) {
    updateLayoutParams {
      this.height = context.dpToPx(height)
    }
  }

  @ModelProp
  fun setColor(@ColorRes colorRes: Int) {
    setBackgroundColor(context.getColor(colorRes))
  }
}
