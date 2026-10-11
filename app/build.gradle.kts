plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.halil.ozel.dovizapp"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.halil.ozel.dovizapp"
        minSdk {
            version = release(24)
        }
        targetSdk {
            version = release(37)
        }
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
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
}
