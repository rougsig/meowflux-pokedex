package com.github.rougsig.meowflux.pokedex.store.routing

import android.os.Parcelable
import com.github.rougsig.meowflux.core.Action
import kotlinx.android.parcel.Parcelize

sealed class RoutingAction : Action {
  @Parcelize
  object ShowHomeScreen : RoutingAction(), Parcelable

  @Parcelize
  data class ShowNewsDetails(val newsId: Int) : RoutingAction(), Parcelable
}
