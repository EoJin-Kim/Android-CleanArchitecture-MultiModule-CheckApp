plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 30
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        dataBinding = true
    }
}

dependencies {

    implementation (project (":domain"))
    implementation (project (":data"))

    implementation (KTX.CORE)
    implementation (AndroidX.APP_COMPAT)
    implementation (Google.MATERIAL)
    implementation (AndroidX.CONSTRAINT_LAYOUT)
    implementation (AndroidX.LEGACY)
    implementation (Firebase.FIREBASE_DATABASE_KTX)
    implementation (Firebase.FIREBASE_FIRESTORE_KTX)
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation("com.google.firebase:firebase-database:19.2.1")
//    implementation("com.google.firebase:firebase-firestore:21.4.0")
    testImplementation (TestTool.JUNIT)
    androidTestImplementation (TestTool.ANDROID_X_JUNIT)
    androidTestImplementation (TestTool.ANDROID_X_ESPRESSO)

    // dagger hilt
    implementation (DaggerHilt.DAGGER_HILT)
    kapt (DaggerHilt.DAGGER_HILT_COMPILER)
    kapt (DaggerHilt.DAGGER_HILT_ANDROIDX_COMPILER)

    // ViewModel
    implementation (AndroidX.LIFECYCLE_VIEW_MODEL)

    // LiveData
    implementation (AndroidX.LIFECYCLE_LIVEDATA)

    // Retrofit
    implementation (Retrofit.RETROFIT)
    implementation (Retrofit.CONVERTER_GSON)
    implementation (Retrofit.CONVERTER_JAXB)

    //okHttp
    implementation (OkHttp.OKHTTP)
    implementation (OkHttp.LOGGING_INTERCEPTOR)

    //coroutines
    implementation (Coroutines.COROUTINES)

    //by viewModel
    implementation (AndroidX.ACTIVITY)
    implementation (AndroidX.FRAGMENT)

    //nav component
    implementation (NavComponent.NAVIGATION_FRAGMENT)
    implementation (NavComponent.NAVIGATION_UI)
    implementation (NavComponent.NAVIGATION_DYNAMIC_FEATURES_FRAGMENT)
    androidTestImplementation (NavComponent.NAVIGATION_TESTING)
    implementation (NavComponent.NAVIGATION_COMPOSE)

    //datastore

    implementation (AndroidX.DATASTORE)

    implementation (Library.NOTIFICATION_BAR_CUSTOM)
    implementation (Library.COUNT_NUMBER_EVENT)
}