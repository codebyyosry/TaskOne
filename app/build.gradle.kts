plugins {
    // Apply Android application plugin using version catalog alias
    alias(libs.plugins.android.application)

    // Apply Kotlin Android plugin using version catalog alias
    alias(libs.plugins.kotlin.android)

    // Apply Kotlin Compose plugin for Jetpack Compose support
    alias(libs.plugins.kotlin.compose)


    alias(libs.plugins.ksp)
}

android {
    // Set unique namespace for your app (used in R class, etc.)
    namespace = "com.yosry.dev.taskone"

    // Android API level to compile the app against
    compileSdk = 35

    defaultConfig {
        // App ID used on device and Play Store
        applicationId = "com.yosry.dev.taskone"

        // Minimum Android version your app supports
        minSdk = 24

        // Android version your app targets (optimizations for this level)
        targetSdk = 35

        // Internal version code (for updates, not shown to users)
        versionCode = 1

        // User-visible version name
        versionName = "1.0"

        // Instrumentation runner for UI tests
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            // Disable code shrinking/obfuscation for release build
            isMinifyEnabled = false

            // ProGuard configuration files used when minify is enabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        // Java source compatibility version
        sourceCompatibility = JavaVersion.VERSION_11

        // Java target bytecode version
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        // Kotlin JVM target compatibility
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
        }
    }

    buildFeatures {
        // Enable Jetpack Compose support in this module
        compose = true
    }
}

dependencies {

    // Core Android KTX extensions (e.g., for Context, Bundle)
    implementation(libs.androidx.core.ktx)

    // Lifecycle support (e.g., lifecycleScope)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Compose support for Android activities
    implementation(libs.androidx.activity.compose)

    // Compose BOM (Bill of Materials) to align versions
    implementation(platform(libs.androidx.compose.bom))

    // Compose UI core library
    implementation(libs.androidx.ui)

    // Compose graphics (shapes, colors, etc.)
    implementation(libs.androidx.ui.graphics)

    // Compose preview tooling (design time previews)
    implementation(libs.androidx.ui.tooling.preview)

    // Material 3 components for Compose (e.g., Scaffold, TopAppBar)
    implementation(libs.androidx.material3)

    // AppCompat for legacy support (optional for Compose)
    implementation(libs.androidx.appcompat)

    // Google Ads SDK (AdMob or similar)
    implementation(libs.ads.mobile.sdk)

    // Unit testing support (JUnit)
    testImplementation(libs.junit)

    // AndroidX testing: JUnit for Android
    androidTestImplementation(libs.androidx.junit)

    // Espresso UI testing
    androidTestImplementation(libs.androidx.espresso.core)

    // Compose testing (JUnit4 support with BOM)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Compose UI tooling (for preview/debugging only)
    debugImplementation(libs.androidx.ui.tooling)

    // Manifest support for UI tests (debug only)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Android 12+ splash screen API support
    implementation(libs.androidx.core.splashscreen)

    // Additional Material3 support (if needed)
    implementation(libs.material3)

    // Room Database
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler) // Replace with KSP if needed

    // Navigation for Jetpack Compose
    implementation(libs.androidx.navigation.compose)

    // Retrofit for networking
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // WorkManager for background tasks
    implementation(libs.androidx.work.runtime.ktx)

    // Hilt for dependency injection
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler) // Replace with KSP if needed
    implementation(libs.androidx.hilt.navigation.compose)
}
