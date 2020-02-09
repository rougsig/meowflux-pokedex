package com.github.rougsig.meowflux.pokedex.ui.core.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import com.airbnb.epoxy.*
import com.github.rougsig.meowflux.pokedex.ui.core.R
import com.github.rougsig.meowflux.pokedex.ui.core.extension.dpToPx
import com.github.rougsig.meowflux.pokedex.ui.core.extension.getSelectableItemBackgroundResource
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class NewsItemView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
  private var listener: (() -> Unit)? = null

  init {
    View.inflate(context, R.layout.news_item, this)
    foreground = context.getDrawable(context.getSelectableItemBackgroundResource())
    val padding = context.dpToPx(16)
    updatePadding(padding, padding, padding, padding)
    setOnClickListener { listener?.invoke() }
  }

  @AfterPropsSet
  fun postBindSetUp() {
    updateLayoutParams {
      height = context.dpToPx(100)
    }
  }

  @TextProp
  fun setTitle(text: CharSequence?) {
    news_title.text = text
  }

  @TextProp
  fun setDate(date: CharSequence?) {
    news_date.text = date
  }

  @ModelProp
  fun setImage(imageUrl: String) {
    Picasso.get()
      .load(imageUrl)
      .into(news_image)
  }

  @CallbackProp
  fun setClickListener(listener: (() -> Unit)?) {
    this.listener = listener
  }
}
