plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinAndroid)
    kotlin("kapt")
}

android {
    namespace = "com.fghilmany.movielist.presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":common"))
    implementation(project(":feature:movielist:domain"))

    implementation(libs.core.ktx)

    implementation(libs.lifecycle.viewmodel.compose)

    // Injection
    implementation(libs.bundles.hilt)
    kapt(libs.dagger.hilt.compiler)
}