package ru.yandex.example.gradle

const val ABC = 123

open class ReportDSL {

    open var shouldSend: Boolean = DEFAULT_BOOL
    open var report: String = EMPTY_STRING
    open var chatId: String = EMPTY_STRING

    fun transform(str: String) {
        //todo
    }

    private companion object {
        const val DEFAULT_BOOL = false
        const val EMPTY_STRING = ""
    }
}