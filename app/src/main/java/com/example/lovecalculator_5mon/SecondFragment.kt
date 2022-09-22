package com.example.lovecalculator_5mon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator_5mon.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentSecondBinding.inflate(layoutInflater)
        return (binding.root)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onGet()
    }
    private fun onGet() {
        val loveModel:LoveModel=arguments?.getSerializable("key") as LoveModel
        binding.firstNameTv.text=loveModel.firstName
        binding.secondNameTv.text=loveModel.secondName
        binding.percentageTv.text=loveModel.percentage
        binding.resultTv.text=loveModel.result
    }
}