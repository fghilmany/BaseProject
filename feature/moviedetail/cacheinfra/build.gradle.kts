plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinAndroid)
    kotlin("kapt")
}

android {
    namespace = "com.fghilmany.moviedetail.cacheinfra"
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
    implementation(project(":feature:moviedetail:cache"))

    implementation(libs.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.dagger.hilt.android)

    // Sqlite
    implementation(libs.bundles.room)
    annotationProcessor(libs.room.compiler)
    kapt(libs.room.compiler)
}