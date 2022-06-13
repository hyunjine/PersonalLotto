package com.hyunjine.personallotto.util

import android.annotation.SuppressLint
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hyunjine.personallotto.data.remote.LottoData
import com.hyunjine.personallotto.view.statistics.StatisticsRecyclerAdapter


object BindingAdapter {



    // RecyclerView
    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter("items")
    @JvmStatic
    fun setItems(
        recyclerView: RecyclerView,
        items: ArrayList<LottoData>?
    ) {
        if (items != null) {
            val mAdapter = recyclerView.adapter as StatisticsRecyclerAdapter?
            mAdapter?.list = items
            mAdapter?.notifyDataSetChanged()
        }
    }
}