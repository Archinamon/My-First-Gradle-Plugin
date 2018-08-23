package ru.yandex.example.gradle

import org.gradle.api.GradleException

open class ReportDSL {

    open var token: String = EMPTY_STRING
        get() = if (field.isEmpty())
            throw GradleException("Define a telegram bot token!")
        else field

    open var report: String = EMPTY_STRING
    open var chatId: String = EMPTY_STRING
    open var silent: Boolean = DEFAULT_BOOL
    open var shouldSend: Boolean = DEFAULT_BOOL

    fun transform(str: String) {
        //todo
    }

    private companion object {
        const val DEFAULT_BOOL = false
        const val EMPTY_STRING = ""
    }
}