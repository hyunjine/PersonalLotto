package com.hyunjine.personallotto.util

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.hyunjine.personallotto.data.remote.LottoData
import com.hyunjine.personallotto.view.datalist.DataListRecyclerAdapter


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
            val mAdapter = recyclerView.adapter as DataListRecyclerAdapter?
            mAdapter?.list = items
            mAdapter?.notifyDataSetChanged()
        }
    }
}