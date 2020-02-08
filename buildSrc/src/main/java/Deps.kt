@Suppress("unused", "MemberVisibilityCanBePrivate")
object Deps {
  private const val kotlinVersion = "1.3.61"

  const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
  const val kotlinStdLibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"

  private const val epoxyVersion = "3.9.0"
  const val epoxyProcessor = "com.airbnb.android:epoxy-processor:$epoxyVersion"
  const val epoxy = "com.airbnb.android:epoxy:$epoxyVersion"

  val coreLibs = arrayOf(
    "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3",
    "com.jakewharton.timber:timber:4.7.1"
  )

  const val supportAnnotations = "androidx.annotation:annotation:1.1.0"
  const val supportCollections = "androidx.collection:collection:1.1.0"
  const val supportCollectionsKtx = "androidx.collection:collection-ktx:1.1.0"
  const val supportTransitions = "androidx.transition:transition:1.1.0"

  val supportCoreLibs = arrayOf(
    supportAnnotations,
    "androidx.core:core:1.1.0",
    "androidx.core:core-ktx:1.1.0",
    supportCollections,
    supportCollectionsKtx
  )

  val supportUiLibs = arrayOf(
    "androidx.appcompat:appcompat:1.1.0",
    "androidx.appcompat:appcompat-resources:1.1.0",
    "androidx.recyclerview:recyclerview:1.1.0",
    "com.google.android.material:material:1.1.0-rc01"
  )

  const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
  const val viewPager2 = "androidx.viewpager2:viewpager2:1.0.0"

  val conductorLibs = arrayOf(
    "com.bluelinelabs:conductor:3.0.0-rc1",
    "com.bluelinelabs:conductor-support:3.0.0-rc1"
  )

  private const val sqldelightVersion = "1.1.4"
  const val sqldelightPlugin = "com.squareup.sqldelight:gradle-plugin:$sqldelightVersion"
  const val sqldelightAndroidDriver = "com.squareup.sqldelight:android-driver:$sqldelightVersion"
  const val sqldelightRxJava = "com.squareup.sqldelight:rxjava2-extensions:$sqldelightVersion"

  const val okHttp = "com.squareup.okhttp3:okhttp:3.12.0"
  const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:3.12.0"
  const val okio = "com.squareup.okio:okio:1.16.0"
  const val moshi = "com.squareup.moshi:moshi:1.8.0"
  const val moshiProcessor = "com.squareup.moshi:moshi-kotlin-codegen:1.8.0"

  private const val retrofitVersion = "2.6.0"
  val retrofitLibs = arrayOf(
    "com.squareup.retrofit2:retrofit:$retrofitVersion",
    "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
  )

  private const val toothpickVersion = "2.1.0"
  const val javaxInject = "javax.inject:javax.inject:1"
  const val toothpickRuntime =
    "com.github.stephanenicolas.toothpick:toothpick-runtime:$toothpickVersion"
  const val toothpickProcessor =
    "com.github.stephanenicolas.toothpick:toothpick-compiler:$toothpickVersion"

  const val picasso = "com.squareup.picasso:picasso:2.71828"

  const val meowflux = "com.github.rougsig:meowflux:master-SNAPSHOT"
}
