package ru.yandex.example.gradle

import retrofit.Endpoints
import retrofit.RestAdapter
import retrofit.client.OkClient

class TelegramEngine(
        token: String,
        private val chatId: String,
        private val silent: Boolean
) {

    private val engine = RestAdapter.Builder()
            .setEndpoint(Endpoints.newFixedEndpoint(API_HOST.format(token)))
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setClient(OkClient())
            .build()
            .create(TelegramAPI::class.java)

    fun sendError(error: String) {
        engine.sendMessage(cleanup(error), chatId, silent)
    }

    fun sendReport(report: String) {
        engine.sendMessage(cleanup(report), chatId, silent)
    }

    private fun cleanup(report: String) = report.replace(UNDERSCORE_SYMBOL, DASH_SYMBOL)

    private companion object {
        const val API_HOST = "https://api.telegram.org/bot%s/"

        const val UNDERSCORE_SYMBOL = "_"
        const val DASH_SYMBOL = "-"
    }
}