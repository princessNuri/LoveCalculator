package com.example.lovecalculator_5mon

import android.app.Application
import androidx.room.Room
import com.example.lovecalculator_5mon.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {



    override fun onCreate() {
        super.onCreate()

    }
}