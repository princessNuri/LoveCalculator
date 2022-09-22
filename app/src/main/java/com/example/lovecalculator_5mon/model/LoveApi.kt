package com.example.lovecalculator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun calculateLove(@Query("fname")firstName:String,@Query("Sname")secondName:String,
    @Header("X-RapidAPI-Key")key:String="9476670278msh03b4d9f4ad99c1ap1ea264jsn61535bb60883",
    @Header("X-RapidAPI-Host")host: String="love-calculator.p.rapidapi.com"): Call<LoveModel>
}