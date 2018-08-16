package ru.yandex.example.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.creating
import org.gradle.kotlin.dsl.getValue

class ReportPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.logger.error("Wow! Our custom plugin configured!")
        val settings = project.extensions.create("report", ReportDSL::class.java)

        project.afterEvaluate {
            if (settings.shouldSend) {
                project.task("sendReport")
            }
        }
    }
}