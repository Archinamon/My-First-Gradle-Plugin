package ru.yandex.example.myfirstgradleplugin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import retrofit.RestAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RestAdapter.Builder().build()
    }
}
