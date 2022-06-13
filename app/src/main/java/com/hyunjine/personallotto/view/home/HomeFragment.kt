package com.hyunjine.personallotto.view.home

import androidx.lifecycle.ViewModelProvider
import com.hyunjine.personallotto.R
import com.hyunjine.personallotto.databinding.FragmentHomeBinding
import com.hyunjine.personallotto.util.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutResourceId: Int get() = R.layout.fragment_home

    override fun setViewModel() {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
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