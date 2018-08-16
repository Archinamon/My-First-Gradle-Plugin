package ru.yandex.example.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.kotlin.dsl.configure

class ReportPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.logger.error("Wow! Our custom plugin configured!")

        project.task("preBuildReport").configure<Task> {

        }
    }
}