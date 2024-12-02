plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.calculatrice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.calculatrice"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.recyclerview)
    implementation(libs.lifecycle.viewmodel.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.junit.jupiter)

    // Unit testing libraries
    testImplementation(libs.junit)
    testImplementation("org.mockito:mockito-core:5.5.0")  // Add Mockito
    testImplementation("org.mockito:mockito-inline:5.5.0") // For mocking final classes (optional)
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0") // JUnit 5 for advanced testing

    // Instrumentation testing libraries
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation("org.junit.jupiter:junit-jupiter:5.10.0")


}