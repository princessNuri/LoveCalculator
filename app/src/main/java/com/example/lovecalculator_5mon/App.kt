package com.example.lovecalculator_5mon

import android.app.Application
import androidx.room.Room
import com.example.lovecalculator_5mon.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {


    companion object{
        lateinit var appDataBase:AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDataBase= Room.databaseBuilder(applicationContext,AppDataBase::class.java,"history")
            .allowMainThreadQueries().build()
    }
}