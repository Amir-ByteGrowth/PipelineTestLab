plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android.gradle.plugin)
    alias(libs.plugins.ksp)
    id("kotlin-kapt")

}

android {
    namespace = "com.example.baseproject2025"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.baseproject2025"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    dataBinding {
        enable = true
    }
    viewBinding{
        enable = true
    }
    buildFeatures {
        buildConfig = true  // must be enabled for libraries
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)



    //Json
    implementation(libs.kotlinx.serialization.json)

    //Chucker
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)

    // Retrofit
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp.logging)
    implementation(libs.okhttp)

    //DataStore
    implementation(libs.androidx.dataStore.core)
    implementation(libs.androidx.dataStore.preferences)





    // for ripple effect
    implementation (libs.balysv.material.ripple)

    //sdpi lib
    implementation (libs.intuit.sdp.android)
    implementation (libs.ssp.android)

    //swipe to referesh
    implementation (libs.androidx.swiperefreshlayout)

    //Timberfb
    implementation (libs.timber)

    // view model, live data,
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.livedata)
    implementation (libs.androidx.lifecycle.common.java)
    implementation (libs.androidx.lifecycle.extensions)

    // Navigation Architecture component
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui.ktx)


    // shimmer
    implementation(libs.shimmer)

    //Lottie for animations
    implementation (libs.lottie)

    //spinkit
    implementation (libs.android.spinkit)

    //Biometric login
    implementation (libs.androidx.biometric)

    //    image picker
    implementation (libs.imagepicker)

    //country code picker
    implementation (libs.libphonenumber.android)
    implementation (libs.countrycodepicker)


    //picasso
    implementation(libs.picasso)

    //carusel manager
    implementation(libs.carousellayoutmanager)



    // flex box layout manager
    implementation(libs.flexbox)

    // samsub
    implementation(libs.com.sumsub.sns.idensic.mobile.sdk)



    implementation (libs.firebase.firestore)
    implementation (libs.firebase.firestore.ktx)

    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // --- Room (with KSP) ---
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)

    // Kotlin Extensions and Coroutines support
    implementation(libs.room.ktx)


}