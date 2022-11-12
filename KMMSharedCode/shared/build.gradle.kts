import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

val libName = "shared"

kotlin {
    android()

    val xcf = XCFramework(libName)
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            xcf.add(this)
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.kmm.kmmsharedcode"
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}

tasks.register("buildReleaseXCFramework", Exec::class.java) {
    description = "Create a Release XCFramework"

    dependsOn("linkReleaseFrameworkIosArm64")
    dependsOn("linkReleaseFrameworkIosX64")

    val arm64FrameworkPath = "$rootDir/shared/build/bin/iosArm64/releaseFramework/${libName}.framework"
    val arm64DebugSymbolsPath =
        "$rootDir/shared/build/bin/iosArm64/releaseFramework/${libName}.framework.dSYM"

    val x64FrameworkPath = "$rootDir/shared/build/bin/iosX64/releaseFramework/${libName}.framework"
    val x64DebugSymbolsPath = "$rootDir/shared/build/bin/iosX64/releaseFramework/${libName}.framework.dSYM"

    val xcFrameworkDest = File("$rootDir/../kmm_xcframework/Release/$libName.xcframework")
    executable = "xcodebuild"
    args(mutableListOf<String>().apply {
        add("-create-xcframework")
        add("-output")
        add(xcFrameworkDest.path)

        // Real Device
        add("-framework")
        add(arm64FrameworkPath)
        add("-debug-symbols")
        add(arm64DebugSymbolsPath)

        // Simulator
        add("-framework")
        add(x64FrameworkPath)
        add("-debug-symbols")
        add(x64DebugSymbolsPath)
    })

    doFirst {
        xcFrameworkDest.deleteRecursively()
    }
}