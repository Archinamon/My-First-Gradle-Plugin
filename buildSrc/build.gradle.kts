plugins {
    `kotlin-dsl`
}

buildscript {
    val kotlin_version = "1.2.51"

    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

repositories {
    google()
    jcenter()
    mavenLocal()
    mavenCentral()
}

dependencies {
    val kotlin_version = "1.2.51"
    compile("com.squareup.okhttp3:okhttp:3.6.0")
    compile("com.squareup.retrofit:retrofit:1.9.0")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version")
    compileOnly("com.android.tools.build:gradle:3.1.4")
}