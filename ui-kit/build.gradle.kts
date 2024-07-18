plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

composeMultiplatformSetup()

kotlin {
    sourceSets.commonMain.dependencies {
        with(compose){
            api(components.resources)
        }
    }
}


compose.resources {
    publicResClass = true
    packageOfResClass = "resources"
    generateResClass = always
}