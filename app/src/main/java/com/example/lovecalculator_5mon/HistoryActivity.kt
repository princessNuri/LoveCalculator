package com.example.lovecalculator_5mon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.lovecalculator_5mon.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    lateinit var binding: ActivityHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        App.appDataBase.loveDao().getAll().observe(this, Observer {listData->
            var data=""
            listData.forEach {loveModel->
                data+="${loveModel.firstName} \n${loveModel.secondName} \n${loveModel.percentage} \n${loveModel.result} \n"
            }
            binding.historyTv.text=data
        })
    }
}