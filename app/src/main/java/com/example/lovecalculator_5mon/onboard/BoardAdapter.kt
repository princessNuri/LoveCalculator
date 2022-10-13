package com.example.lovecalculator_5mon.onboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator_5mon.Prefs
import com.example.lovecalculator_5mon.R
import com.example.lovecalculator_5mon.databinding.FragmentBoardBinding
import com.example.lovecalculator_5mon.databinding.PagerBoardBinding

class BoardAdapter(var context: Context, private var navController: NavController, private var _binding: FragmentBoardBinding)
    : RecyclerView.Adapter<BoardAdapter.ViewHolder>() {
    private val boards= arrayListOf<Board>()
    init {
        boards.add(Board(R.raw.love11,"Hello)"))
        boards.add(Board(R.raw.love22,"Welcome!"))
        boards.add(Board(R.raw.love33,"Let's get started!"))
        boards.add(Board(R.raw.love11,"Calculate love!"))

    }
    inner class ViewHolder(
        private var binding: PagerBoardBinding
    )
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(board: Board) {
            binding.lotti.setAnimation(board.image)
            binding.textTitle.text = board.title
            _binding.btnSkip.setOnClickListener {
                val prefs= Prefs(context)
                prefs.saveState()
                navController.navigateUp()
            }
            binding.btnStart.setOnClickListener {

                val prefs=Prefs(context)

                prefs.saveState()

                navController.navigate(R.id.mainFragment)

            }
            if (boards.lastIndexOf(board) == boards.lastIndex){
                binding.btnStart.visibility = View.VISIBLE
            } else{
                binding.btnStart.visibility = View.INVISIBLE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardAdapter.ViewHolder {
        return ViewHolder(PagerBoardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BoardAdapter.ViewHolder, position: Int) {
        holder.bind(boards[position])
    }

    override fun getItemCount()=boards.size
}