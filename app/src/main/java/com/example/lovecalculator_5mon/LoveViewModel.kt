package com.example.lovecalculator_5mon

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.model.LoveModel

class LoveViewModel:ViewModel() {
    private val repository=     Repository()

    fun getLiveLoveModel(firstName:String,secondName:String):LiveData<LoveModel>{
        return repository.getLove(firstName,secondName)
    }
}