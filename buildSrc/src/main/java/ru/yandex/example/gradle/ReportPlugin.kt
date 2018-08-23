package ru.yandex.example.gradle

import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle
import org.gradle.kotlin.dsl.creating
import org.gradle.kotlin.dsl.getValue

class ReportPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.logger.error("Wow! Our custom plugin configured!")
        val settings = project.extensions.create("report", ReportDSL::class.java)

        val isTeamcity = project.hasProperty("teamcity")
        if (!isTeamcity) {
            return
        }

        project.afterEvaluate {
            val engine = TelegramEngine(
                    settings.token,
                    settings.chatId,
                    settings.silent
            )

            project.gradle.addBuildListener(
                    object : BuildListenerAdapter() {
                        override fun buildFinished(result: BuildResult?) {
                            if (result == null) {
                                return
                            }

                            if (result.failure != null) {
                                engine.sendError(result.failure!!.message
                                        ?: "[http://....](Build failed)")
                                return
                            }

                            engine.sendReport(result.action)
                        }
                    }
            )
        }
    }

    private open class BuildListenerAdapter : BuildListener {
        override fun settingsEvaluated(settings: Settings?) {
        }

        override fun buildFinished(result: BuildResult?) {
        }

        override fun projectsLoaded(gradle: Gradle?) {
        }

        override fun buildStarted(gradle: Gradle?) {
        }

        override fun projectsEvaluated(gradle: Gradle?) {
        }
    }
}