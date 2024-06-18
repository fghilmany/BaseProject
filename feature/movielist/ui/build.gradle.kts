plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinAndroid)
    kotlin("kapt")
}

android {
    namespace = "com.fghilmany.movielist.ui"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {

    implementation(project(":common"))
    implementation(project(":feature:movielist:domain"))
    implementation(project(":feature:movielist:presentation"))

    implementation(libs.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)

    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material)
    implementation(libs.material3)
    implementation(libs.coil)

    implementation(libs.navigation.compose)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))

    implementation(libs.dagger.hilt.navigation.compose)
}