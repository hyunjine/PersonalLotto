package com.hyunjine.personallotto.view.main

import androidx.lifecycle.ViewModelProvider
import com.hyunjine.personallotto.R
import com.hyunjine.personallotto.data.remote.LottoClient
import com.hyunjine.personallotto.data.remote.LottoService
import com.hyunjine.personallotto.data.repo.Repository
import com.hyunjine.personallotto.databinding.FragmentMainBinding
import com.hyunjine.personallotto.util.ViewModelFactory
import com.hyunjine.personallotto.util.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_main
    private lateinit var repository: Repository

    override fun setViewModel() {
        repository = Repository(LottoClient().getClient())
        viewModel = ViewModelProvider(this, ViewModelFactory(repository))[MainViewModel::class.java]
    }

    override fun viewInitialize() {
        binding.viewModel = viewModel
    }

    override fun viewEvent() {
        viewModel.getLottoNumber()
    }

}