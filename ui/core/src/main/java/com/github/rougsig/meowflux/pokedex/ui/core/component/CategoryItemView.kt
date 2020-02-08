package com.github.rougsig.meowflux.pokedex.ui.core.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import com.airbnb.epoxy.*
import com.github.rougsig.meowflux.pokedex.ui.core.R
import com.github.rougsig.meowflux.pokedex.ui.core.extension.getSelectableItemBackgroundResource
import kotlinx.android.synthetic.main.category_item.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT, fullSpan = false)
class CategoryItemView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), EpoxyModel.SpanSizeOverrideCallback {
  private var listener: (() -> Unit)? = null

  init {
    View.inflate(context, R.layout.category_item, this)
    foreground = context.getDrawable(context.getSelectableItemBackgroundResource())
    setOnClickListener { listener?.invoke() }
  }

  @TextProp
  fun setTitle(text: CharSequence?) {
    category_title.text = text
  }

  @ModelProp
  fun setCardBackground(@ColorRes colorRes: Int) {
    category_background.backgroundTintList = context.getColorStateList(colorRes)
  }

  @ModelProp
  fun setBackground(@ColorRes colorRes: Int) {
    setBackgroundResource(colorRes)
  }

  @CallbackProp
  fun setListener(listener: (() -> Unit)?) {
    this.listener = listener
  }

  override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int): Int {
    return totalSpanCount / 2
  }
}
