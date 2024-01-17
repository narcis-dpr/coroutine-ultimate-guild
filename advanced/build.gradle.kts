plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.coroutines.advanced"
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
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material")
    // Testing Dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.5.4")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.5.4")

    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

    // Networking
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // Image Loading
    implementation ("io.coil-kt:coil-compose:1.4.0")

    // RxJava
    implementation ("io.reactivex.rxjava3:rxjava:3.1.3")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.0")

    // Room
    implementation ("androidx.room:room-runtime:2.4.1")
    implementation ("androidx.room:room-ktx:2.4.1")
    kapt("androidx.room:room-compiler:2.4.1")

    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.5.0-alpha02")
}