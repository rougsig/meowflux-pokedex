package com.github.rougsig.meowflux.pokedex.network

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://sheet.best/api/sheets/4cdb6c8d-2d7e-479f-8e28-3f9b401deda9/"

private val moshi = Moshi.Builder()
  .build()

private val client = OkHttpClient.Builder()
  .addLoggingInterceptor()
  .build()

private val retrofit = Retrofit.Builder()
  .baseUrl(BASE_URL)
  .addConverterFactory(MoshiConverterFactory.create(moshi))
  .client(client)
  .build()

val api: PokemonApi = retrofit.create(PokemonApi::class.java)

private fun OkHttpClient.Builder.addLoggingInterceptor(): OkHttpClient.Builder {
  val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
      println("OkHttp: $message")
    }
  })
  loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
  return this.addNetworkInterceptor(loggingInterceptor)
}
