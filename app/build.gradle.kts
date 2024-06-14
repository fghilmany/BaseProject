@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    kotlin("kapt")
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.fghilmany.baseproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fghilmany.baseproject"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":feature:moviedetail:domain"))
    implementation(project(":feature:moviedetail:api"))
    implementation(project(":feature:moviedetail:apiinfra"))
    implementation(project(":feature:moviedetail:cache"))
    implementation(project(":feature:moviedetail:cacheinfra"))
    implementation(project(":feature:moviedetail:composite"))
    implementation(project(":feature:moviedetail:decorator"))
    implementation(project(":feature:moviedetail:presentation"))
    implementation(project(":feature:moviedetail:ui"))
    implementation(project(":feature:movielist:domain"))
    implementation(project(":feature:movielist:api"))
    implementation(project(":feature:movielist:apiinfra"))
    implementation(project(":feature:movielist:presentation"))
    implementation(project(":feature:movielist:ui"))
    implementation(project(":core:sqlite"))
    implementation(project(":core:rest"))

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material)
    implementation(libs.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.navigation.compose)

    implementation(libs.coil)

    // Http
    implementation(libs.retrofit)
    implementation(libs.moshi.kotlin)
    implementation(libs.converter.moshi)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // Injection
    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)
    implementation(libs.dagger.hilt.navigation.compose)

    // Sqlite
    implementation(libs.room.ktx)
    annotationProcessor(libs.room.compiler)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)
}
kapt {
    correctErrorTypes = true
}