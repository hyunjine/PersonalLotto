package com.hyunjine.personallotto.view.statistics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hyunjine.personallotto.data.remote.LottoData
import com.hyunjine.personallotto.databinding.RecyclerDataListBinding

class StatisticsRecyclerAdapter: RecyclerView.Adapter<StatisticsRecyclerAdapter.RecentViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(word: String, position: Int)
        fun onRemoveClick(position: Int)
    }

    private lateinit var listener: OnItemClickListener

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    var list = ArrayList<LottoData>()

    inner class RecentViewHolder(val binding: RecyclerDataListBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(list: LottoData){
            binding.data = list
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewHolder = RecentViewHolder(RecyclerDataListBinding.inflate(LayoutInflater.from(parent.context) ,parent,false))

    override fun onBindViewHolder(holder: RecentViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}

