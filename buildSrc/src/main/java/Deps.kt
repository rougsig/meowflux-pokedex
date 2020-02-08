@Suppress("unused", "MemberVisibilityCanBePrivate")
object Deps {
  private const val kotlinVersion = "1.3.61"

  const val androidGradlePlugin = "com.android.tools.build:gradle:3.5.3"
  const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
  const val kotlinStdLibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"

  private const val toothpickVersion = "2.1.0"
  const val toothpickProcessor =
    "com.github.stephanenicolas.toothpick:toothpick-compiler:$toothpickVersion"
  val coreLibs = arrayOf(
    "javax.inject:javax.inject:1",
    "com.github.stephanenicolas.toothpick:toothpick-runtime:$toothpickVersion",
    kotlinStdLibJdk7,
    "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3",
    "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3",
    "com.jakewharton.timber:timber:4.7.1"
  )

  private const val retrofitVersion = "2.6.0"
  val networkLibs = arrayOf(
    "com.squareup.okhttp3:okhttp:3.12.0",
    "com.squareup.okhttp3:logging-interceptor:3.12.0",
    "com.squareup.okio:okio:1.16.0",
    "com.squareup.moshi:moshi:1.8.0",
    "com.squareup.moshi:moshi-kotlin-codegen:1.8.0",
    "com.squareup.retrofit2:retrofit:$retrofitVersion",
    "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
  )

  private const val sqldelightVersion = "1.1.4"
  val storeLibs = arrayOf(
    "com.squareup.sqldelight:gradle-plugin:$sqldelightVersion",
    "com.squareup.sqldelight:android-driver:$sqldelightVersion",
    "com.squareup.sqldelight:rxjava2-extensions:$sqldelightVersion"
  )

  val domainLibs = arrayOf(
    "com.github.rougsig:meowflux:4.0.1"
  )

  private const val epoxyVersion = "3.8.0"
  const val epoxyProcessor = "com.airbnb.android:epoxy-processor:$epoxyVersion"
  val uiLibs = arrayOf(
    "com.airbnb.android:epoxy:$epoxyVersion",
    "androidx.annotation:annotation:1.1.0",
    "androidx.collection:collection:1.1.0",
    "androidx.collection:collection-ktx:1.1.0",
    "androidx.transition:transition:1.1.0",
    "androidx.constraintlayout:constraintlayout:1.1.3",
    "androidx.viewpager2:viewpager2:1.0.0",
    "com.squareup.picasso:picasso:2.71828",
    "androidx.core:core:1.1.0",
    "androidx.core:core-ktx:1.1.0",
    "androidx.appcompat:appcompat:1.1.0",
    "androidx.appcompat:appcompat-resources:1.1.0",
    "androidx.recyclerview:recyclerview:1.1.0",
    "com.google.android.material:material:1.1.0-rc01",
    "com.bluelinelabs:conductor:3.0.0-rc1",
    "com.bluelinelabs:conductor-support:3.0.0-rc1"
  )
}
