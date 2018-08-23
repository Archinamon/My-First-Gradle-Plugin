package ru.yandex.example.gradle

class TelegramEngine(private val token: String) {

    private fun cleanup(report: String) = report.replace(UNDERSCORE_SYMBOL, DASH_SYMBOL)

    private companion object {
        const val API_HOST = "https://api.telegram.org"

        const val UNDERSCORE_SYMBOL = "_"
        const val DASH_SYMBOL = "-"
    }
}