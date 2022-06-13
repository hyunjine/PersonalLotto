package com.hyunjine.personallotto.view.statistics

import androidx.lifecycle.ViewModelProvider
import com.hyunjine.personallotto.R
import com.hyunjine.personallotto.databinding.FragmentStatisticsBinding
import com.hyunjine.personallotto.util.base.BaseFragment

class StatisticsFragment : BaseFragment<FragmentStatisticsBinding, StatisticsViewModel>() {
    override val layoutResourceId: Int get() = R.layout.fragment_statistics

    override fun setViewModel() {
        viewModel = ViewModelProvider(this)[StatisticsViewModel::class.java]
    }

    override fun initView() {
        binding.run {
            setBindingWithVM()
        }
    }

    override fun onEvent() {

    }

    private fun setBindingWithVM() = viewModel.also { binding.viewModel = it }
}