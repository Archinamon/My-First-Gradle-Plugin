package ru.yandex.example.gradle

open class ReportDSL {

    open var shouldSend: Boolean = false
    open var report: String = ""

    fun transform(str: String) {
        //todo
    }
}