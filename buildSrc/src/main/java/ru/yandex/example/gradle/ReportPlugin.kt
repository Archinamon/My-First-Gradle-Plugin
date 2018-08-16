package ru.yandex.example.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.creating
import org.gradle.kotlin.dsl.getValue

class ReportPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.logger.error("Wow! Our custom plugin configured!")

        val preBuildReport by project.tasks.creating {
            doFirst {
                logger.error("This task launch!")
            }

            doLast {
                logger.error("This task finished!")
            }
        }
    }
}