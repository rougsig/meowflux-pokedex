# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Crashlytics
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

# TOOTHPICK CONFIGURATION. Reflection based.
#
# Do not obfuscate classes with Injected Constructors
-keepnames class * { @javax.inject.Inject <init>(...); }
# Do not obfuscate classes with Injected Fields
-keepnames class * { @javax.inject.Inject <fields>; }
# Do not obfuscate classes with Injected Methods
-keepnames class * { @javax.inject.Inject <methods>; }
-keep @android.support.annotation.Keep class *
-dontwarn javax.inject.**
-dontwarn javax.annotation.**
-keep class **__Factory { *; }
-keep class **__MemberInjector { *; }
-adaptclassstrings

-keep class toothpick.** { *; }

-keep @javax.inject.Singleton class *

# Conductor rules
#
# Keep default constructor of change handlers, required by Conductor
-keepclassmembers public class * extends com.bluelinelabs.conductor.ControllerChangeHandler {
   public <init>(...);
}
