package com.github.rougsig.meowflux.pokedex.network

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import toothpick.config.Module
import javax.inject.Inject
import javax.inject.Provider

private const val BASE_URL = "https://sheet.best/api/sheets/4cdb6c8d-2d7e-479f-8e28-3f9b401deda9/"

private fun OkHttpClient.Builder.addLoggingInterceptor(): OkHttpClient.Builder {
  val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
      println("OkHttp: $message")
    }
  })
  loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
  return this.addNetworkInterceptor(loggingInterceptor)
}

class NeworkModule : Module() {
  private fun createMoshi(): Moshi {
    return Moshi.Builder().build()
  }

  private fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .addLoggingInterceptor()
      .build()
  }

  init {
    bind(Moshi::class.java)
      .toInstance(createMoshi())

    bind(OkHttpClient::class.java)
      .toInstance(createOkHttpClient())

    bind(Retrofit::class.java)
      .toProvider(RetrofitProvider::class.java)
      .singletonInScope()

    bind(PokemonApi::class.java)
      .toProvider(PokemonApiProvider::class.java)
      .singletonInScope()
  }
}

private class RetrofitProvider @Inject constructor(
  private val moshi: Moshi,
  private val client: OkHttpClient
) : Provider<Retrofit> {
  override fun get(): Retrofit {
    return Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(MoshiConverterFactory.create(moshi))
      .client(client)
      .build()
  }
}

private class PokemonApiProvider @Inject constructor(
  private val retrofit: Retrofit
) : Provider<PokemonApi> {
  override fun get(): PokemonApi {
    return retrofit.create(PokemonApi::class.java)
  }
}
