plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.android.cleancoderealtime"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.android.cleancoderealtime"
        minSdk = 26
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
//Additional for KSP set up
kotlin {
    jvmToolchain(17)
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //compose navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")

    //compose with view model
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    //compose constrainlayout
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    
    //compose
    
    implementation("androidx.compose.ui:ui:1.4.0")
    // Toolkit
    implementation("androidx.compose.material:material:1.4.0")
    // UI Tooling preview
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0")


    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Glide with compose
    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")

    //for observe as state
    implementation("androidx.compose.runtime:runtime-livedata:1.6.4")

    implementation ("io.coil-kt:coil-compose:2.4.0")

    //Dagger-hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    ksp("com.google.dagger:hilt-android-compiler:2.48.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    implementation("com.google.code.gson:gson:2.10.1")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.4")
    implementation ("androidx.navigation:navigation-compose:2.7.7")
}