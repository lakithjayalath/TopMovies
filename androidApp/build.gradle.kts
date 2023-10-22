plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.topmovies.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.topmovies.android"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
    val koinComposeVersion = "3.5.0"
    val coilVersion = "2.4.0"
    val accompanistVersion = "0.32.0"
    val navVersion = "2.7.4"

    implementation(projects.shared)
    implementation("androidx.compose.ui:ui:1.5.4")
    implementation("androidx.compose.ui:ui-tooling:1.5.4")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.4")
    implementation("androidx.compose.foundation:foundation:1.3.1")
    implementation("androidx.compose.material:material:1.5.3")
    implementation("androidx.activity:activity-compose:1.8.0")

    implementation("androidx.compose.foundation:foundation:1.5.4")
    implementation("io.insert-koin:koin-androidx-compose:$koinComposeVersion")
    implementation("io.coil-kt:coil-compose:$coilVersion")
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
    implementation("androidx.navigation:navigation-compose:$navVersion")
}