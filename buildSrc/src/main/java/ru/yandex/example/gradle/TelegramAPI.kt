package ru.yandex.example.gradle

import retrofit.client.Response
import retrofit.http.GET
import retrofit.http.POST
import java.io.File

interface TelegramAPI {

    @GET("")
    fun sendMessage(token: String, msg: String): Response

    @POST("")
    fun sendFile(token: String, file: File): Response
}