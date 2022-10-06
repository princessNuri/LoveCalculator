package com.example.lovecalculator_5mon

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator_5mon.databinding.FragmentMainBinding
import com.example.lovecalculator_5mon.databinding.FragmentSecondBinding
import com.example.lovecalculator_5mon.room.AppDataBase
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment  : Fragment() {
    lateinit var binding: FragmentMainBinding
    private val viewModel:LoveViewModel by viewModels()
    @Inject
    lateinit var helper: Helper
    @Inject
    lateinit var dataBase: AppDataBase
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

                with(viewModel) {
                    getLiveLoveModel(firstNameEd.text.toString(),secondNameEd.text.toString()).observe(
                        this@MainFragment.viewLifecycleOwner,
                                Observer {loveData->
                                    binding.calculateBtn.text=loveData.percentage
                                    helper.showToast(requireContext())
                                    dataBase.loveDao().insert(loveData)
                                })
                }
//                App.api.calculateLove(firstNameEd.text.toString(),secondNameEd.text.toString()).enqueue(object :
//                    retrofit2.Callback<LoveModel>{
//                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
//                        if(response.isSuccessful){
//                            Log.e("raya","${response.body()?.percentage}")
//                            val loveModel=response.body()
//                            val bundle=Bundle()
//                            bundle.putSerializable("key",loveModel)
//                            findNavController().navigate(R.id.secondFragment,bundle)
//                            binding.firstNameEd.text.clear()
//                            binding.secondNameEd.text.clear()
//                        }}
//
//                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
//                        Log.e("raya","${t.message}")
//                    }
//
//                })
            }
            switchBtn.setOnClickListener{
                findNavController().navigate(R.id.historyActivity)
            }
        }
    }
}