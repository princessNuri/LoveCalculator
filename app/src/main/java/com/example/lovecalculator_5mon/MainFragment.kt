package com.example.lovecalculator_5mon

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator_5mon.databinding.FragmentMainBinding
import com.example.lovecalculator_5mon.databinding.FragmentSecondBinding
import retrofit2.Call
import retrofit2.Response

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMainBinding.inflate(layoutInflater)
        return (binding.root)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }
    private fun initClicker() {
        with(binding){
            calculateBtn.setOnClickListener{
                App.api.calculateLove(firstNameEd.text.toString(),secondNameEd.text.toString()).enqueue(object :
                    retrofit2.Callback<LoveModel>{
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if(response.isSuccessful){
                            Log.e("raya","${response.body()?.percentage}")
                            val loveModel=response.body()
                            val bundle=Bundle()
                            bundle.putSerializable("key",loveModel)
                            findNavController().navigate(R.id.secondFragment,bundle)
                            binding.firstNameEd.text.clear()
                            binding.secondNameEd.text.clear()
                        }}

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("raya","${t.message}")
                    }

                })
            }
        }
    }
}