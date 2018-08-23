package ru.yandex.example.gradle

import retrofit.Endpoints
import retrofit.RestAdapter
import retrofit.client.OkClient

class TelegramEngine(
        private val token: String
) {

    private val engine = RestAdapter.Builder()
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setClient(OkClient())
            .setEndpoint(Endpoints.newFixedEndpoint(API_HOST))
            .build()

    private fun cleanup(report: String) = report.replace(UNDERSCORE_SYMBOL, DASH_SYMBOL)

    private companion object {
        const val API_HOST = "https://api.telegram.org"

        const val UNDERSCORE_SYMBOL = "_"
        const val DASH_SYMBOL = "-"
    }
}