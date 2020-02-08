package com.github.rougsig.meowflux.pokedex.ui.core.extension

import android.content.Context
import android.content.res.Resources


fun Context.dpToPx(dp: Int): Int = resources.dpToPx(dp)
fun Context.dpToPxF(dp: Int): Float = resources.dpToPxF(dp)
fun Context.dpToPxF(dpF: Float): Float = resources.dpToPx(dpF)
fun Context.dpToPx(dpF: Float): Int = resources.dpToPx(dpF).toInt()

fun Context.spToPx(sp: Int): Int = resources.spToPx(sp)
fun Context.spToPxF(sp: Int): Float = resources.spToPxF(sp)

fun Resources.dpToPx(dp: Int): Int = Math.round(dpToPxF(dp))
fun Resources.dpToPxF(dp: Int): Float = displayMetrics.density * dp
fun Resources.dpToPx(dpF: Float): Float = displayMetrics.density * dpF

fun Resources.spToPx(sp: Int): Int = Math.round(spToPxF(sp))
fun Resources.spToPxF(sp: Int): Float = displayMetrics.scaledDensity * sp
