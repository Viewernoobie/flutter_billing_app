allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    repositories {
        google()
        mavenCentral()
    }
}

/*
Fix untuk plugin lama Flutter yang belum punya namespace
contoh: flutter_vibrate
*/
subprojects {
    afterEvaluate {
        if (project.hasProperty("android")) {
            val androidExtension = project.extensions.findByName("android")
            if (androidExtension is com.android.build.gradle.BaseExtension) {
                if (androidExtension.namespace == null) {
                    androidExtension.namespace = project.group.toString()
                }
            }
        }
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
