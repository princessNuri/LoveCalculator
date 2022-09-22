package com.example.lovecalculator_5mon

import android.app.Application
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.RetrofitService

class App: Application() {
    companion object{
        lateinit var api: LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitService=RetrofitService()
        api=retrofitService.getLoveApi()
    }
}