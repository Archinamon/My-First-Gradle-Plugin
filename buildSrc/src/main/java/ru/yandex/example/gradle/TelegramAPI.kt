package ru.yandex.example.gradle

import retrofit.client.Response
import retrofit.http.GET
import retrofit.http.POST
import retrofit.http.Path
import retrofit.http.Query
import java.io.File

interface TelegramAPI {

    @GET("sendMessage?parse_mode=Markdown")
    fun sendMessage(
            @Query("text") msg: String,
            @Query("chat_id") chatId: String,
            @Query("disable_notification") silent: Boolean
    ): Response

    @POST("")
    fun sendFile(file: File): Response
}