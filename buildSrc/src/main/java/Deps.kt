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
    "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3"
  )

  private const val moshiVersion = "1.9.2"
  private val moshiProcessor = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
  private val entityLibs = arrayOf(
    "com.squareup.moshi:moshi:$moshiVersion"
  )

  private const val retrofitVersion = "2.7.1"
  val networkLibs = arrayOf(
    "com.squareup.okhttp3:okhttp:4.3.1",
    "com.squareup.okhttp3:logging-interceptor:4.3.1",
    *entityLibs,
    "com.squareup.retrofit2:retrofit:$retrofitVersion",
    "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
  )

  private const val sqldelightVersion = "1.1.4"
  val storeLibs = arrayOf(
    "com.squareup.sqldelight:gradle-plugin:$sqldelightVersion",
    "com.squareup.sqldelight:android-driver:$sqldelightVersion"
  )

  val domainLibs = arrayOf(
    "com.github.rougsig:meowflux:d524f49fe4"
  )

  private const val epoxyVersion = "3.9.0"
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
