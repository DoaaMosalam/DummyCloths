
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // Hilt plugin
    alias(libs.plugins.hilt.plugin)

    // KAPT plugin
    alias(libs.plugins.kaptKotlin)

    //navigation
//    alias(libs.plugins.nav.component)
}

android {
    namespace = "com.doaa.mosalam.birthdaycard"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.doaa.mosalam.birthdaycard"
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
        sourceCompatibility = JavaVersion.toVersion(libs.versions.javaVersion.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.javaVersion.get())
    }
    kotlinOptions {
        jvmTarget = libs.versions.javaVersion.get()
    }
    buildFeatures {
        viewBinding = true
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
    // recycler View
    implementation(libs.androidx.recyclerview)
    //cart view
    implementation(libs.androidx.cardview)

    //picasso
    implementation(libs.picasso)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //coroutines
        implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

//view model
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.hilt.navigation.fragment)


    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //navigation component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)





}