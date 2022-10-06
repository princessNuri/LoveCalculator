package com.example.lovecalculator_5mon

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator_5mon.room.LoveDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi,private val dao: LoveDao  ) {

    fun getLove(firstName:String,secondName:String):MutableLiveData<LoveModel>{
        val love :MutableLiveData<LoveModel> =MutableLiveData()
        api.calculateLove(firstName,secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if(response.isSuccessful){
                    love.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("raya","onFailure: ${t.message}")
            }

        })
        return love
    }
    fun test(){
        dao.getAllAtoZ()
    }
}